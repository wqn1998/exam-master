package com.lititi.exams.web.service;

/**
 * 工厂模式的应用场景：根据用户需求动态创建不同类型的产品和服务
 * 比如根据用户选择的支付方式动态创建对应的支付服务对象，包括支付宝和微信支付
 *
 * 支付接口
 * @author weiqineng * @version 1.0
 * @date 2024/3/11 15:02
 */
public interface PaymentService {
    String pay(double amount);
}
