package com.lititi.exams.web.enums;

import com.fawkes.core.constants.BaseConstants;

/**
 * @author weiqineng * @version 1.0
 * @date 2024/2/24 22:18
 */
public enum BizCodeMsgEnum {
  FILE_ERROR(BaseConstants.BASIC_ERROR_CODE - 20, "文件不能为空"),
  PARAM_ERROR(BaseConstants.BASIC_ERROR_CODE - 10, "参数错误");

  private Integer code;
  private String msg;

  public Integer getCode() {
    return this.code;
  }

  public String getMsg() {
    return this.msg;
  }

  private BizCodeMsgEnum(final Integer code, final String msg) {
    this.code = code;
    this.msg = msg;
  }
}
