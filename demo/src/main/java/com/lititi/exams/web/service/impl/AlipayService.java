package com.lititi.exams.web.service.impl;

import com.lititi.exams.web.config.PaymentServiceFactory;
import com.lititi.exams.web.service.PaymentService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author weiqineng * @version 1.0
 * @date 2024/3/11 15:05
 */
@Service
public class AlipayService implements PaymentService {
  @Override
  public String pay(double amount) {
    return "Using Alipay to pay: " + amount;
  }
}
