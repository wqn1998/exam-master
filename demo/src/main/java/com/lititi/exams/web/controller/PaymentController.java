package com.lititi.exams.web.controller;

import com.lititi.exams.web.service.impl.PaymentServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weiqineng * @version 1.0
 * @date 2024/3/11 15:31
 */

@RestController
public class PaymentController {

    @Autowired
    private PaymentServiceClient paymentServiceClient;

    @GetMapping("/processPayment")
    public String processPayment(@RequestParam("paymentMethod")String paymentMethod, @RequestParam("amount")double amount){
        String payment = paymentServiceClient.processPayment(paymentMethod, amount);
        return payment;
    }
}
