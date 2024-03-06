package com.lititi.exams.web.controller;

import com.lititi.exams.commons2.object.CommonResultObject;
import com.lititi.exams.web.anno.Debounce;
import com.lititi.exams.web.enums.BizCodeMsgEnum;
import com.lititi.exams.web.param.PublishContentParam;
import com.lititi.exams.web.service.ContentService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.IOException;
import java.text.ParseException;

/**
 * @author weiqineng * @version 1.0
 * @date 2024/2/25 21:52
 */
@RestController
@RequestMapping("/content")
public class ContentController {

    @Resource
    private ContentService contentService;

    @Debounce
    @PostMapping(path = "/publish",produces = {"application/json;charset=UTF-8"})
    public CommonResultObject addContent(PublishContentParam contentParam) throws Exception {
        if (contentParam == null) {
            CommonResultObject resultObject = new CommonResultObject();
            return resultObject.buildErrorResult(String.valueOf(BizCodeMsgEnum.PARAM_ERROR));
        }
        CommonResultObject resultObject = new CommonResultObject();
        resultObject.addObject("content", contentService.addContent(contentParam));
        return resultObject;
    }

    @Debounce
    @GetMapping(path = "/list")
    public CommonResultObject getContent(@RequestParam("pageSize") Integer pageSize, @RequestParam("pageNum") Integer pageNum, @RequestParam("order") String order, @RequestParam("contentCode") String contentCode, @RequestParam("title") String title,
                                         @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate,@RequestParam("publishFlag") Integer publishFlag) throws ParseException {
        CommonResultObject resultObject = new CommonResultObject();
        resultObject.addObject("content", contentService.getContent(pageSize, pageNum, order, contentCode, title, startDate, endDate,publishFlag));
        return resultObject;
    }

    @Debounce
    @PostMapping(path = "/updatePublish",produces = {"application/json;charset=UTF-8"})
    public CommonResultObject updatePublish(@RequestParam("contentCode") String contentCode) throws ParseException {
        CommonResultObject resultObject = new CommonResultObject();
        resultObject.addObject("content", contentService.updatePublish(contentCode));
        return resultObject;
    }

    @Debounce
    @GetMapping(path = "/getRedisList")
    public CommonResultObject getRedisList() {
        CommonResultObject resultObject = new CommonResultObject();
        resultObject.addObject("content", contentService.getRedisList());
        return resultObject;
    }

}
