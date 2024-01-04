package com.example.elmback.service.impl;

import com.example.elmback.mapper.CartMapper;
import com.example.elmback.pojo.Cart;
import com.example.elmback.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;

    @Override
    public void addCart(Cart cart) {
        cart.setQuantity(0);
        cartMapper.addCart(cart);
    }

    @Override
    public void addQuantity(Integer cartId) {
        cartMapper.addQuantity(cartId);
    }

    @Override
    public void substrateQuantity(Integer cartId) {
        Integer quantity = cartMapper.getCartQuantity(cartId);
        if (quantity > 0) {
            cartMapper.substrateQuantity(cartId);
        }else {
            cartMapper.setQuantity(cartId);
        }
    }
}
