package com.lititi.exams.web.config;

import com.lititi.exams.web.service.PaymentService;
import com.lititi.exams.web.service.impl.AlipayService;
import com.lititi.exams.web.service.impl.WechatPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author weiqineng * @version 1.0
 * @date 2024/3/11 15:17
 */
@Component
public class PaymentServiceFactory {

  /**字段注入：
   * 耦合度高：字段注入会增加类之间的耦合度，使得类的依赖关系不太明显。
   * 难以测试：在单元测试中，字段注入可能会导致难以模拟依赖对象。
   * 可能导致循环依赖：如果依赖关系循环引用，字段注入可能会导致问题。
   */
//  @Autowired
//  private AlipayService alipayService;
//
//  @Autowired
//  private WechatPayService wechatPayService;

  /**
   * 构造方法注入：可以解决循环依赖问题，但是代码量较多：需要编写额外的构造函数和属性声明，使代码看起来更冗长。
   * 依赖注入的改动会导致类的改动：如果需要注入新的依赖，需要修改类的构造函数。
   * @param paymentMethod
   * @return
   */
  private final AlipayService alipayService;
  private final WechatPayService wechatPayService;

  @Autowired
  public PaymentServiceFactory(AlipayService alipayService, WechatPayService wechatPayService) {
    this.alipayService = alipayService;
    this.wechatPayService = wechatPayService;
  }

  public PaymentService createPaymentService(String paymentMethod){
    if ("alipay".equals(paymentMethod)){
      return alipayService;
    }else if ("wechat".equals(paymentMethod)){
      return wechatPayService;
    }
    return null;
  }

}
