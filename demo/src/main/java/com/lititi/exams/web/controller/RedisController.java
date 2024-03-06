package com.lititi.exams.web.controller;

import com.lititi.exams.web.service.RedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author weiqineng * @version 1.0
 * @date 2024/2/26 14:39
 */
@RestController
public class RedisController {
  @Resource
  private RedisService redisService;

  @GetMapping("/getList")
  public void getList(){
    redisService.getList();
  }
}
