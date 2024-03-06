package com.lititi.exams.web.interceptor;

import com.lititi.exams.web.anno.Debounce;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author weiqineng * @version 1.0
 * @date 2024/3/6 10:18
 */
@Component
public class DebounceInterceptor implements HandlerInterceptor {

  private final Map<String,Long> lastAccessTimeMap = new ConcurrentHashMap<>();
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    Method method = ((HandlerMethod) handler).getMethod();
    //isAnnotationPresent 检查方法、类或字段是否具有特定的注解,可以根据注解的存在与否来执行不同的操作
    if (method.isAnnotationPresent(Debounce.class)){
      String key = method.getName();
      long currentTimeMillis = System.currentTimeMillis();
      Long lastAccessTime = lastAccessTimeMap.getOrDefault(key, 0L);
      if (currentTimeMillis - lastAccessTime < 2000){ //2秒只能执行一次
        response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value()); //状态码 429 请求过多
        return false;
      }
      lastAccessTimeMap.put(key,currentTimeMillis);
    }
    return true;
  }
}
