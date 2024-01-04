package com.example.elmback.config;

import com.example.elmback.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDateTime;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).excludePathPatterns("/login","/register","/business","/businessList","/business/orderTypeId/{orderTypeId}"
        ,"/business/search/{name}","/business/businessId/{businessId}","/food/{businessId}/{userId}","/food/businessId/{businessId}");
    }
}
