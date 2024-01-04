package com.example.elmback.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.example.elmback.pojo.Result;
import com.example.elmback.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    JwtUtils jwtUtils = new JwtUtils();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token == null) {
            Result error = Result.error("没有登录");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        } else {
            try {
                Map<String, Object> map = jwtUtils.parseToken(token);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }
}
