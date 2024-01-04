package com.example.elmback.controller;

import com.example.elmback.pojo.Orders;
import com.example.elmback.pojo.Result;
import com.example.elmback.pojo.User;
import com.example.elmback.service.UserService;
import com.example.elmback.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/userInfo/{userId}")
    public Result getUserInfo(@PathVariable Integer userId){
        User user = userService.getUserInfo(userId);
        return Result.success(user);
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        User user1 =  userService.login(user);
        JwtUtils jwtUtils = new JwtUtils();
        if(user1!=null){
            Map<String,Object> map = new HashMap<>();
            map.put("userId", user1.getUserId());
            map.put("userName",user1.getUserName());
            map.put("name",user1.getName());
            String token = jwtUtils.createToken(map);
            user1.setToken(token);
            return Result.success(user1);
        }else {
            return Result.error("用户名或密码错误");
        }

    }

    @PostMapping("/register")
    public Result register(@RequestBody User user){
        User newUser = userService.register(user);
        if (newUser != null){
            return Result.success(newUser);
        }else {
            return Result.error("该用户名已被注册");
        }

    }

    @GetMapping("/orderListNotPay/{userId}")
    public Result getOrdersByUserIdNotPay(@PathVariable Integer userId){
        List<Orders> ordersList = userService.getOrdersNotPay(userId);
        return Result.success(ordersList);
    }
    @GetMapping("/orderListPay/{userId}")
    public Result getOrdersByUserIdPay(@PathVariable Integer userId){
        List<Orders> ordersList = userService.getOrdersPay(userId);
        return Result.success(ordersList);
    }
}
