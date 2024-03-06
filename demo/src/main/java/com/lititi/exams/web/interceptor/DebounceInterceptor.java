package com.lititi.exams.web.interceptor;

import com.lititi.exams.web.anno.Debounce;
import com.lititi.exams.web.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
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
    /**
     * 一般方式是将用户信息放在请求头中的 Authorization 字段中，使用 JWT 或其他认证方式生成包含用户信息的 token，并将该 token 放在 Authorization 请求头中
     * 所以从Authorization获取用户的相关信息
     *
     * token示例： Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.
     * eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
     */
    String token = request.getHeader("Authorization");
    String userId = null;
    if (token != null && token.startsWith("Bearer ")){ //startsWith:用于检查一个字符串是否以指定的前缀开头。通常用于判断一个字符串是否以特定字符或子字符串开始
      String jwtToken = token.substring(7);
      userId = extractUserIdFromToken(jwtToken); //从token提取用户信息
    }
    User user = getUserInfo(userId);

    Method method = ((HandlerMethod) handler).getMethod();
    //isAnnotationPresent 检查方法、类或字段是否具有特定的注解,可以根据注解的存在与否来执行不同的操作
    if (method.isAnnotationPresent(Debounce.class)){
      String key = userId + method.getName(); //用户id + 方法名作为key，标识不是同一用户，避免多个用户同一时间请求同一接口时，防抖动失效
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

  /**
   * 解析token的方法
   * @param jwtToken
   * @return
   */
  private String extractUserIdFromToken(String jwtToken){
    //解析JWT Token 提取用户信息
    Claims claims = Jwts.parser()
            .setSigningKey("mySecretKey") //设置密钥
            .parseClaimsJws(jwtToken.replace("Bearer ", ""))//去掉Bearer 获取完整token
            .getBody();
    //从JWT的payload 载荷获取用户信息
    String userId = claims.getSubject();
    return userId;
  }

  private User getUserInfo(String userId){
    //如需要用户其他信息做校验则从数据库根据userId查询用户信息即可，一般的查询即可
    //这里我不需要就省略了 所以直接new了一个空对象
    User user = new User();
    return user;
  }
}
