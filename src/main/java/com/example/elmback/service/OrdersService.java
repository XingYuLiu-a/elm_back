package com.example.elmback.service;

import com.example.elmback.pojo.Business;
import com.example.elmback.pojo.OrderDetailet;
import com.example.elmback.pojo.Orders;

import java.util.List;

public interface OrdersService {
    Integer addOrders(Orders orders);

    List<OrderDetailet> getOrderDetailets(Integer orderId);

    Business getBusinessByOrderId(Integer orderId);

    Orders getOrderByOrderId(Integer orderId);

    void updateOrders(Orders orders);

    void deleteOrders(Integer orderId);
}
