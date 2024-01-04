package com.example.elmback.service;

import com.example.elmback.pojo.Cart;

public interface CartService {
    void addCart(Cart cart);

    void addQuantity(Integer cartId);

    void substrateQuantity(Integer cartId);
}
