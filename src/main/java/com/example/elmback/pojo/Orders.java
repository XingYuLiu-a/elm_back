package com.example.elmback.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    private Integer orderId;
    private Integer userId;
    private Integer businessId;
    private String orderDate;
    private Double orderTotal;
    private Integer daId;
    private Integer orderState;

    private DeliveryAddress deliveryAddress;
    private List<OrderDetailet> orderDetailetList;
    private List<Cart> cartList;
    private Business business;
}
