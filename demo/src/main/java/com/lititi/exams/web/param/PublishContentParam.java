package com.lititi.exams.web.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * @author weiqineng * @version 1.0
 * @date 2024/2/24 22:00
 */
@Data
public class PublishContentParam implements Serializable {
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("内容标题")
    private String title;
    @ApiModelProperty("归属分类")
    private String classify;
    @ApiModelProperty("发布时间")
    private String publishDate;
    @ApiModelProperty("发布状态")
    private Integer publishFlag;
    @ApiModelProperty("延迟发布时间")
    private String publishDelayDate;
    @ApiModelProperty("有效截至时间")
    private String effectiveDate;
    @ApiModelProperty("分享状态")
    private Integer shareFlag;
    @ApiModelProperty("正文内容")
    private String content;
    @ApiModelProperty("内容编码")
    private String contentCode;
    @ApiModelProperty("图片路径")
    private String imageUrl;
    @ApiModelProperty("图片")
    private MultipartFile image;

}
