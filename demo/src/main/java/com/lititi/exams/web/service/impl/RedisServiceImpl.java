package com.lititi.exams.web.service.impl;

import com.lititi.exams.commons2.object.CommonResultObject;
import com.lititi.exams.web.entity.User;
import com.lititi.exams.web.service.ContentService;
import com.lititi.exams.web.service.RedisService;
import org.springframework.data.geo.Metric;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author weiqineng * @version 1.0
 * @date 2024/2/26 14:40
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Resource
    private ContentService contentService;

    @Override
    public void getList() {
        contentService.getRedisList();
        cacheTest("1","2");
    }

    //缓存数据
    public void cacheTest(String key,String value){
        //获取一个 ValueOperations<String, String> 对象。这个对象可以用于执行与字符串值相关的操作
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        //存值
        ops.set(key,value);
        //取值
        String values = ops.get(key);
        System.out.println(values);
        redisTemplate.delete(key);
    }

    //分布式锁
    public void distributedLockTest(String lockKey){
        Boolean locked = redisTemplate.opsForValue().setIfAbsent(lockKey, "locked");
        if (locked){
            try {
                //执行需要进行互拆锁操作的业务逻辑，比如写订单，减库存
            }finally {
                redisTemplate.delete(lockKey);
            }
        }else {
            //获取锁失败，执行相应的业务逻辑
        }
    }

    //限流
    public void rateLimitTest(String lockKey){
        //限流阈值 如60s内请求或者操作数量是否大于100
        long limit = 100;
        //过期时间
        long expireInSeconds = 60;
        //通过 opsForValue().increment() 方法对指定 key 的值进行自增操作。lockKey 是要操作的键名，1 表示每次自增的步长为 1。该方法会返回自增后的值给变量 count
        Long count = redisTemplate.opsForValue().increment(lockKey,1);
        if (count == 1){
            //使用 expire(lockKey, expireInSeconds, TimeUnit.SECONDS) 方法为该 key 设置过期时间。
            // 如果计数器值为 1，表示第一次对该计数器进行操作，此时设置该 key 在 expireInSeconds 秒后过期失效
            redisTemplate.expire(lockKey,expireInSeconds, TimeUnit.SECONDS);
        }
        if (count > limit){
            //超过限流阈值，执行相应的处理逻辑
        }else {
            //未达到限流阈值，正常处理
        }
    }

    //会话存储
    public void sessionStorageTest(String sessionId, User user){
       String key = "session" + sessionId;
       //key 是会话的键，user.toString() 将用户信息转换为字符串存储
       redisTemplate.opsForValue().set(key,user.toString());
       //设置过期时间30分钟
       redisTemplate.expire(key,30,TimeUnit.MINUTES);
    }

    //发布/订阅
    public void publishSubscribeTest(){
        //发布
        redisTemplate.convertAndSend("channel","message");
        //订阅
//        MessageListenerAdapter listener = new MessageListenerAdapter(new RedisMessageListener()); //Redis 提供的一个消息监听器适配器
//        redisTemplate.execute((RedisCallback<Object>) connection ->{
//            //通过 Redis 连接对象的 subscribe() 方法进行订阅操作。listener 是一个消息监听器，用于处理接收到的消息；
//            // "channel".getBytes() 将频道名称转换为字节数组，表示要订阅的频道。
//            connection.subscribe(listener,"channel".getBytes());
//            return null;
//        });
    }

    //排行榜和排名
    public void leaderboard(){
        String leaderboardKey = "leaderboard";
        String userOne = "aoao";
        Double score = 100.0;
        String userTwo = "wy";
        Double scores = 200.0;

        redisTemplate.opsForZSet().add(leaderboardKey,userOne,score);
        redisTemplate.opsForZSet().add(leaderboardKey,userTwo,scores);

        //获取排名从 0 到 9 的元素,使用了 reverseRange() 方法，表示按照分数从高到低进行排列。leaderboardKey 是有序集合的键名
        Set<String> topUser = redisTemplate.opsForZSet().reverseRange(leaderboardKey, 0, 9);

        //获取排名从 0 到 9 的元素,使用了range() 方法，表示按照分数从低到高进行排列。leaderboardKey 是有序集合的键名
        Set<String> range = redisTemplate.opsForZSet().range(leaderboardKey, 0, 9);

        for (String user : topUser) {
            //获取指定成员user的分数
            Double score1 = redisTemplate.opsForZSet().score(leaderboardKey, user);
            System.out.println(score1);
        }
    }

    //用户积分榜
    public void userRankingTest(String userId,int score){
        String userRankingKey = "user_ranking";
        //userRankingKey 是有序集合的键名,在指定的有序集合中，将指定成员 userId 的分数增加 score
        //如果指定成员不存在，该方法会自动创建一个新的成员，并将其初始分数设为 0，然后再将其分数增加 score；如果指定的有序集合不存在，也会自动创建一个新的有序集合
        //场景：用于计数器的实现，例如在线人数统计
        redisTemplate.opsForZSet().incrementScore(userRankingKey,userId,score);
    }

    //地理位置的应用
    public void geoLocationTest(){
        String locationKey = "location";
        String place1 = "place1";
        double longitude1 = 10.1234;
        double latitude1 = 20.5678;
        String place2 = "place2";
        double longitude2 = 30.9876;
        double latitude2 = 40.5432;

        redisTemplate.opsForGeo().add(locationKey, new Point(longitude1, latitude1),place1);
        redisTemplate.opsForGeo().add(locationKey, new Point(longitude2, latitude2),place2);

        //计算地理位置集合中两个地理位置之间的距离，Metrics.KILOMETERS表示以公里为单位进行距离计算
        redisTemplate.opsForGeo().distance(locationKey,place1,place2, Metrics.KILOMETERS);
    }
}
