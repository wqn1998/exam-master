package com.lititi.exams.web.datasource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author weiqineng * @version 1.0
 * @date 2024/3/5 14:37
 */
//@Configuration
public class CacheConfig {
    /**
     * 存在高并发隐患：两个成员变量多个线程修改共享状态
     * jedisConnectionFactory,每次调用都会创建一个实例
     * 多个线程访问redisTemplate,会出现竞争条件
     */

    @Value("${cache.redis.host}")
    private String redisHost;

    @Value("${cache.redis.port}")
    private Integer redisPort;

    /**
     * 解决：加锁，对共享状态加锁
     * 使用线程安全对象，ConcurrentHashMap
     * 单例模式：jedisConnectionFactory设置成单例
     */
    private static JedisConnectionFactory jedisConnectionFactory;

    /**
     * 使用线程安全对象
     *
     * @return
     */
    private Map<String, JedisConnectionFactory> connectionFactoryConcurrentHashMap = new ConcurrentHashMap<>();

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        //连接池配置实列
        return new JedisPoolConfig();
    }

    /**
     * 线程问题版本
     * @return
     */
//  @Bean
//  public JedisConnectionFactory jedisConnectionFactory(){
//    JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
//    connectionFactory.setHostName(redisHost);
//    connectionFactory.setPort(redisPort);
//    return connectionFactory;
//  }

    /**
     * 解决:单例模式+双检锁
     * JedisConnectionFactory 连接工厂
     * @return
     */
    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        if (jedisConnectionFactory == null) {
            synchronized (this) {
                if (jedisConnectionFactory == null) {
                    JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
                    connectionFactory.setPort(redisPort);
                    connectionFactory.setHostName(redisHost);
                }
            }
        }
        return jedisConnectionFactory;
    }

    /**
     * concurrentHashMap
     *
     * @return
     */

    @Bean
    public JedisConnectionFactory jedisConnectionFactory1(){
        /**
         * computeIfAbsent()
         * 当指定键在映射中不存在时，使用提供的函数生成一个值，并将其与键关联。如果键已经存在，则不执行任何操作
         *
         * 与之相反的 computeIfPresent()
         * 当指定键在映射中存在时，对键关联的值执行给定函数并将结果重新放回到映射中。如果键不存在，则不执行任何操作
         *
         * 拓展:
         * putIfAbsent(K 键，V 值):如果键已经存在，则不会插入，返回原有值;如果键不存在，则插入键值对并返回 null
         *
         * getOrDefault("key",jedisConnectionFactory1()): 指定键的值，如果键不存在，则返回默认值
         *
         * entrySet():  Set<Map.Entry<String, JedisConnectionFactory>> entrySet = connectionFactoryConcurrentHashMap.entrySet();
         *         for (Map.Entry<String, JedisConnectionFactory> factoryEntry : entrySet) {
         *             JedisConnectionFactory value = factoryEntry.getValue();
         *             String key = factoryEntry.getKey();
         *         }
         */
        return connectionFactoryConcurrentHashMap.computeIfAbsent("default",key ->{
            JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
            connectionFactory.setPort(redisPort);
            connectionFactory.setHostName(redisHost);
            return connectionFactory;
        });
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate() {
        return createRedisTemplate();
    }

    private RedisTemplate<String, String> createRedisTemplate() {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }
}
