package com.lititi.exams.web.service.impl;

import com.fawkes.core.utils.EntityTool;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lititi.exams.commons2.object.CommonResultObject;
import com.lititi.exams.web.dao.PublishContentMapper;
import com.lititi.exams.web.entity.PublishContent;
import com.lititi.exams.web.param.PublishContentParam;
import com.lititi.exams.web.service.ContentService;
import com.lititi.exams.web.service.RedisService;
import com.lititi.exams.web.util.ObjectConverterUtil;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.io.File;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 发布信息实现类
 *
 * @author weiqineng * @version 1.0
 * @date 2024/2/24 21:55
 */
@Service("ContentService")
public class ContentServiceImpl implements ContentService {
    private static String UPLOADED_FOLDER = "C:\\Users\\50408\\Desktop\\ltt\\exams2-master\\demo\\src\\main\\resources\\static\\image";

    @Resource
    private PublishContentMapper contentMapper;

    @Resource
    private RedisService redisService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 新增数据
     *
     * @param contentParam
     * @return 成功数据
     */
    @Override
    public CommonResultObject addContent(PublishContentParam contentParam) throws Exception {
        ReentrantLock lock = new ReentrantLock();

        ObjectConverterUtil.convert(contentParam,PublishContent.class);

        PublishContent convert = convert(contentParam);
        if (!contentParam.getImage().isEmpty()) {
            //获取原始图片的拓展名
            String fileName = System.currentTimeMillis() + "_" + contentParam.getImage().getOriginalFilename();
            //新的文件名字
            String newFileName = UUID.randomUUID() + fileName;
            //封装上传文件位置的全路径
            File targetFile = new File(UPLOADED_FOLDER, newFileName);
            //把本地文件上传到封装上传的文件位置的全路径
            contentParam.getImage().transferTo(targetFile);
            //设置路径
            contentParam.setImageUrl(newFileName);
        }
        if (contentParam.getId() == null) {
            EntityTool.insertEntity(convert);
            contentMapper.insert(convert);
        } else {
            EntityTool.updateEntity(convert);
            contentMapper.updateByPrimaryKeySelective(convert);
        }
        CommonResultObject resultObject = new CommonResultObject();
        return resultObject.addObject("contentItem",contentParam);
    }

    @Override
    public CommonResultObject getContent(Integer pageSize,Integer pageNum,String order,String contentCode, String title, String startDate, String endDate,Integer publishFlag) throws ParseException {
        PageHelper.startPage(pageNum,pageSize);
        List<PublishContent> contentList = contentMapper.getContentList(contentCode, title, startDate, endDate, publishFlag);
        PageInfo<PublishContent> pageInfo = new PageInfo<>(contentList);
        CommonResultObject resultObject = new CommonResultObject();
        return resultObject.addObject("contentItem",pageInfo);
    }

    @Override
    public int updatePublish(String contentCode) throws ParseException {
        PublishContent content = contentMapper.getContentByDate(contentCode);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date specifiedDate = dateFormat.parse(String.valueOf(content.getEffectiveDate()));

        Date date = new Date();
        if (specifiedDate.before(date)){
            return -1;
        }else {
            saveContent(content);
            return contentMapper.updatePublishFlag(contentCode);
        }
    }

    @Override
    public CommonResultObject getRedisList() {
        redisService.getList();
        CommonResultObject resultObject = new CommonResultObject();
        return resultObject.addObject("redisContent",redisTemplate.opsForValue().get("content"));
    }

    @CachePut(value = "saveContent")
    public void saveContent(PublishContent content) {
        // 将数据保存到 Redis 中
        redisTemplate.opsForValue().set("content", content, 30, TimeUnit.MINUTES);
    }

    public PublishContent convert(PublishContentParam contentParam){
        PublishContent content = new PublishContent();
        content.setTitle(contentParam.getTitle());
        content.setClassify(contentParam.getClassify());
        content.setPublishDate(Timestamp.valueOf(contentParam.getPublishDate()));
        content.setPublishFlag(contentParam.getPublishFlag());
        content.setPublishDelayDate(Timestamp.valueOf(contentParam.getPublishDelayDate()));
        content.setEffectiveDate(Timestamp.valueOf(contentParam.getEffectiveDate()));
        content.setShareFlag(contentParam.getShareFlag());
        content.setContent(contentParam.getContent());
        content.setContentCode(contentParam.getContentCode());
        content.setImageUrl(contentParam.getImageUrl());
        return content;
    }


}
