package com.lititi.exams.web.config;

import com.lititi.exams.web.interceptor.ApiUsageInterceptor;
import com.lititi.exams.web.interceptor.DebounceInterceptor;
import com.lititi.exams.web.interceptor.LoginInterceptor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Autowired
    private DebounceInterceptor debounceInterceptor;

    @Autowired
    private ApiUsageInterceptor apiUsageInterceptor;

    /**
     * 用于注册拦截器
     * 向springMVC配置添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**");
        registry.addInterceptor(debounceInterceptor);
//        registry.addInterceptor(apiUsageInterceptor);
    }
}
