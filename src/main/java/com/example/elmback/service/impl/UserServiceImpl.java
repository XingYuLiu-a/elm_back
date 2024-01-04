package com.example.elmback.service.impl;

import com.example.elmback.mapper.UserMapper;
import com.example.elmback.pojo.*;
import com.example.elmback.service.UserService;
import com.example.elmback.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserInfo(Integer userId) {
        return userMapper.getUserInfo(userId);
    }

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public User register(User user) {
        User newUser = userMapper.getUserByUserName(user.getUserName());
        if (newUser == null){
            user.setDelTag(1);
            userMapper.register(user);
            return user;
        }else {
            return null;
        }
    }

    @Override
    public List<Orders> getOrdersNotPay(Integer userId) {
        List<Orders> ordersList = userMapper.getOrdersNotPay(userId);
        for(Orders orders : ordersList){
            Business newBusiness = userMapper.getBusiness(orders.getBusinessId());
            orders.setBusiness(newBusiness);
            List<OrderDetailet> orderDetailetList = userMapper.getOrderDetailet(orders.getOrderId());
            for(OrderDetailet orderDetailet : orderDetailetList){
                Food newFood = userMapper.getFood(orderDetailet.getFoodId());
                orderDetailet.setFood(newFood);
            }
            orders.setOrderDetailetList(orderDetailetList);
        }
        return ordersList;
    }

    @Override
    public List<Orders> getOrdersPay(Integer userId) {
        List<Orders> ordersList = userMapper.getOrdersPay(userId);
        for(Orders orders : ordersList){
            Business newBusiness = userMapper.getBusiness(orders.getBusinessId());
            orders.setBusiness(newBusiness);
            List<OrderDetailet> orderDetailetList = userMapper.getOrderDetailet(orders.getOrderId());
            for(OrderDetailet orderDetailet : orderDetailetList){
                Food newFood = userMapper.getFood(orderDetailet.getFoodId());
                orderDetailet.setFood(newFood);
            }
            orders.setOrderDetailetList(orderDetailetList);
        }
        return ordersList;
    }
}
