package com.lititi.exams.web.service.impl;

import com.lititi.exams.web.config.PaymentServiceFactory;
import com.lititi.exams.web.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author weiqineng * @version 1.0
 * @date 2024/3/11 15:31
 */
@Service
public class PaymentServiceClient {
  @Autowired
  private PaymentServiceFactory paymentServiceFactory;

  public String processPayment(String paymentMethod,double amount){
    PaymentService paymentService = paymentServiceFactory.createPaymentService(paymentMethod);
    if (paymentService != null){
      return paymentService.pay(amount);
    }else {
      return "Unsupported payment method: " + paymentMethod;
    }
  }
}
