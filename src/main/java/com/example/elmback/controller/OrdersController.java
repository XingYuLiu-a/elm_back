package com.example.elmback.controller;

import com.example.elmback.pojo.Business;
import com.example.elmback.pojo.OrderDetailet;
import com.example.elmback.pojo.Orders;
import com.example.elmback.pojo.Result;
import com.example.elmback.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @PostMapping("/orders")
    public Result addOrders(@RequestBody Orders orders){
        Integer orderId = ordersService.addOrders(orders);
        if (orderId == -1){
            return Result.error("这个商家还有一个订单没有支付,请先支付上一个订单!");
        }else{
            return Result.success(orderId);
        }
    }

    @GetMapping("/orderDetailet/{orderId}")
    public Result getOrderDetailets(@PathVariable Integer orderId){
        List<OrderDetailet> orderDetailetList = ordersService.getOrderDetailets(orderId);
        return Result.success(orderDetailetList);
    }

    @GetMapping("/order/businessInfo/{orderId}")
    public Result getBusinessByOrderId(@PathVariable Integer orderId){
        Business business = ordersService.getBusinessByOrderId(orderId);
        return Result.success(business);
    }

    @GetMapping("/orders/{orderId}")
    public Result getOrderByOrderId(@PathVariable Integer orderId){
        Orders orders = ordersService.getOrderByOrderId(orderId);
        return Result.success(orders);
    }

    @PutMapping("/orders")
    public Result updateOrders(@RequestBody Orders orders){
        ordersService.updateOrders(orders);
        return Result.success();
    }

    @DeleteMapping("/orders/{orderId}")
    public Result deleteOrders(@PathVariable Integer orderId){
        ordersService.deleteOrders(orderId);
        return Result.success();
    }
}
