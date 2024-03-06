package com.lititi.exams.web.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.Arrays;

/**
 * 切面类记录访问日志
 *
 * @author weiqineng * @version 1.0
 * @date 2024/2/29 14:55
 */
@Aspect
@Component
public class AccessLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(AccessLogAspect.class);

    @Before("execution(* com.lititi.exams.web.controller.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        // 将访问日志记录到Redis
        Jedis jedis = new Jedis("localhost");
        String logKey = "access_" + methodName;
        jedis.lpush(logKey,"argument:" + Arrays.toString(args));
        jedis.close();
        logger.info("Method {} called with arguments: {}", methodName, Arrays.toString(args));
    }
}
