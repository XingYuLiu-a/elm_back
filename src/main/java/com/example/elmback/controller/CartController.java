package com.example.elmback.controller;

import com.example.elmback.pojo.Cart;
import com.example.elmback.pojo.Result;
import com.example.elmback.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/cart")
    public Result addCart(@RequestBody Cart cart){
        cartService.addCart(cart);
        return Result.success();
    }

    @PutMapping("/cart/addQuantity/{cartId}")
    public Result addQuantity(@PathVariable Integer cartId){
        cartService.addQuantity(cartId);
        return Result.success();
    }

    @PutMapping("/cart/substrateQuantity/{cartId}")
    public Result substrateQuantity(@PathVariable Integer cartId){
        cartService.substrateQuantity(cartId);
        return Result.success();
    }
}
