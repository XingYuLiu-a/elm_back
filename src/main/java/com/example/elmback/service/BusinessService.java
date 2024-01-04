package com.example.elmback.service;

import com.example.elmback.pojo.Business;

import java.util.List;

public interface BusinessService {
    List<Business> list();
    List<Business> search(String name);
    List<Business> getByOrderTypeId(Integer orderTypeId);
    void add(Business business);
    void delete(Integer businessId);

    Business getByBusinessId(Integer businessId);

    Double total(Integer businessId,Integer userId);
    Integer getQuantity(Integer businessId,Integer userId);

}
