package com.lititi.exams.web.service.impl;

import com.lititi.exams.web.service.PaymentService;
import org.springframework.stereotype.Service;

/**
 * @author weiqineng * @version 1.0
 * @date 2024/3/11 15:14
 */
@Service
public class WechatPayService implements PaymentService {
  @Override
  public String pay(double amount) {
    return "Using Wechat Pay to pay: " + amount;
  }
}
