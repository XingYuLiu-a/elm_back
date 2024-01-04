package com.example.elmback.service;

import com.example.elmback.pojo.DeliveryAddress;

import java.util.List;

public interface DeliveryAddressService {
    List<DeliveryAddress> list(Integer userId);

    void addAddress(DeliveryAddress deliveryAddress);

    void deleteAddress(Integer daId);
    void updateAddress(DeliveryAddress deliveryAddress);

    DeliveryAddress getByDaId(Integer daId);

}
