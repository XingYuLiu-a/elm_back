package com.example.elmback.service.impl;

import com.example.elmback.mapper.DeliveryAddressMapper;
import com.example.elmback.pojo.DeliveryAddress;
import com.example.elmback.service.DeliveryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.PrimitiveIterator;

@Service
public class DeliveryAddressImpl implements DeliveryAddressService {
    @Autowired
    private DeliveryAddressMapper deliveryAddressMapper;

    @Override
    public List<DeliveryAddress> list(Integer userId) {
        return deliveryAddressMapper.list(userId);
    }

    @Override
    public void addAddress(DeliveryAddress deliveryAddress) {
        deliveryAddressMapper.addAddress(deliveryAddress);
    }

    @Override
    public void deleteAddress(Integer daId) {
        deliveryAddressMapper.deleteAddress(daId);
    }

    @Override
    public void updateAddress(DeliveryAddress deliveryAddress) {
        deliveryAddressMapper.updateAddress(deliveryAddress);
    }

    @Override
    public DeliveryAddress getByDaId(Integer daId) {
        return deliveryAddressMapper.getByDaId(daId);
    }

}
