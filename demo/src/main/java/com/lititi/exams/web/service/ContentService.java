package com.lititi.exams.web.service;

import com.lititi.exams.commons2.object.CommonResultObject;
import com.lititi.exams.web.param.PublishContentParam;
import java.io.IOException;
import java.text.ParseException;

/**
 * @author weiqineng * @version 1.0
 * @date 2024/2/22 21:54
 */
public interface ContentService {
    /**
     * 新增发布信息接口
     * @param contentParam
     * @return
     */
    CommonResultObject addContent(PublishContentParam contentParam) throws Exception;

    /**
     * 查询接口
     * @param pageSize
     * @param pageNum
     * @param order
     * @param contentCode
     * @param title
     * @param startDate
     * @param endDate
     * @param publishFlag
     * @return
     */
    CommonResultObject getContent(Integer pageSize,Integer pageNum,String order,String contentCode, String title, String startDate, String endDate,Integer publishFlag) throws ParseException;

    /**
     * 修改上架状态
     * @param contentCode
     * @return
     */
    int updatePublish(String contentCode) throws ParseException;

    CommonResultObject getRedisList();
}
