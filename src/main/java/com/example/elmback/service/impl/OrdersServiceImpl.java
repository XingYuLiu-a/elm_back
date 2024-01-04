package com.example.elmback.service.impl;

import com.example.elmback.mapper.OrdersMapper;
import com.example.elmback.pojo.*;
import com.example.elmback.service.OrdersService;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;
    @Override
    public Integer addOrders(Orders orders) {
        Integer count = ordersMapper.check(orders);
        if (count == 0){
            LocalDateTime dateTime = LocalDateTime.now();
            String date=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(dateTime);
            orders.setOrderDate(date);
            orders.setOrderState(0);
            ordersMapper.addOrders(orders);
            List<Cart> cartList = ordersMapper.getCarts(orders.getBusinessId(),orders.getUserId());
            for(Cart cart :cartList){
                OrderDetailet orderDetailet = new OrderDetailet();
                orderDetailet.setOrderId(orders.getOrderId());
                orderDetailet.setQuantity(cart.getQuantity());
                orderDetailet.setFoodId(cart.getFoodId());
                ordersMapper.addOrderDetailet(orderDetailet);
                ordersMapper.updateCartQuantity(cart.getCartId());
            }
            return orders.getOrderId();
        } else {
            return -1;
        }
    }

    @Override
    public List<OrderDetailet> getOrderDetailets(Integer orderId) {
        List<OrderDetailet> orderDetailetList = ordersMapper.getOrderDetailets(orderId);
        for(OrderDetailet orderDetailet : orderDetailetList){
            Food newFood = new Food();
            newFood.setFoodPrice(ordersMapper.getFoodByFoodId(orderDetailet.getFoodId()).getFoodPrice());
            newFood.setFoodImg(ordersMapper.getFoodByFoodId(orderDetailet.getFoodId()).getFoodImg());
            newFood.setFoodImg(ordersMapper.getFoodByFoodId(orderDetailet.getFoodId()).getFoodImg());
            newFood.setFoodName(ordersMapper.getFoodByFoodId(orderDetailet.getFoodId()).getFoodName());
            newFood.setFoodExplain(ordersMapper.getFoodByFoodId(orderDetailet.getFoodId()).getFoodExplain());
            orderDetailet.setFood(newFood);
        }
        return orderDetailetList;
    }

    @Override
    public Business getBusinessByOrderId(Integer orderId) {
        Business business = ordersMapper.getBusiness(ordersMapper.getBusinessId(orderId));
        return business;
    }

    @Override
    public Orders getOrderByOrderId(Integer orderId) {
        Orders orders = ordersMapper.getOrderByOrderId(orderId);
        orders.setDeliveryAddress(ordersMapper.getAddressByDaId(orders.getDaId()));
        return orders;
    }

    @Override
    public void updateOrders(Orders orders) {
        ordersMapper.updateOrders(orders);
    }

    @Override
    public void deleteOrders(Integer orderId) {
        ordersMapper.deleteOrders(orderId);
        ordersMapper.deleteOrderDetails(orderId);
    }
}
