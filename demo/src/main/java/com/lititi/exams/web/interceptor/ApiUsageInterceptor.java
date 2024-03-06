package com.lititi.exams.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 用于接口访问计数器和用户配额管理
 *
 * @author weiqineng * @version 1.0
 * @date 2024/2/29 15:44
 */
@Component
public class ApiUsageInterceptor implements HandlerInterceptor {

    private Jedis jedis = new Jedis("localhost");
    private Map<String, Integer> apiCounter = new ConcurrentHashMap<>();

    /**
     * 在请求处理器方法执行之前被调用。可以用来进行一些前置处理，比如校验操作、日志记录等。
     * 如果该方法返回 true，则继续执行后续的拦截器及请求处理器；如果返回 false，则结束整个处理流程
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();

        //计数器加1
        apiCounter.compute(requestURI,(key,value) -> (value == null) ? 1 : value + 1);

        //验证用户身份，限制使用次数
        String userId = request.getHeader("userId");
            if (!userId.isEmpty()){
                String userKey = "user_" + userId;
//            Long incr = jedis.incr(userKey);
//            if (incr > 100){
//                response.setStatus(HttpServletResponse.SC_REQUEST_ENTITY_TOO_LARGE);
//                return false;
//            }
                Integer currentUsage = apiCounter.getOrDefault(userKey, 0);
                if (currentUsage > 100){
                    response.setStatus(HttpServletResponse.SC_REQUEST_ENTITY_TOO_LARGE);
                    return false;
                }
                apiCounter.put(userKey,currentUsage + 1);
        }
        return true;
    }

    /**
     * 在请求处理器方法执行之后、视图渲染之前被调用。可以用来进行一些后置处理，比如修改数据模型、修改视图等   prefix表示在前面、之前
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 在整个请求处理完成后被调用，即在视图渲染完毕后。通常用于资源清理工作，比如释放资源、记录日志等。
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        jedis.close();
    }
}
