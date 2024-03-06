package com.lititi.exams;

import com.lititi.exams.web.datasource.DataSourceConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan(basePackages = {"com.lititi"})
@MapperScan(basePackages = {"com.lititi.exams.web.dao"})
@Import(DataSourceConfig.class)
@EnableCaching
public class WebMainApplication {
    public static void main(String[] args) {
        String env = System.getenv("springProfileActive");
        String locationPath = "spring.config.location=optional:classpath:/dev/";
        new SpringApplicationBuilder(WebMainApplication.class).properties(locationPath).build().run(args);
        System.out.println("Hello world!");
    }
}