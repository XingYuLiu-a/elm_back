package com.example.elmback.service;

import com.example.elmback.pojo.Orders;
import com.example.elmback.pojo.User;

import java.util.List;

public interface UserService {

    User getUserInfo(Integer userId);
    User login(User user);

    User register(User user);

    List<Orders> getOrdersNotPay(Integer userId);
    List<Orders> getOrdersPay(Integer userId);
}
