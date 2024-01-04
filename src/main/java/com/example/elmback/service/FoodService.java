package com.example.elmback.service;

import com.example.elmback.pojo.Cart;
import com.example.elmback.pojo.Food;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface FoodService {
    List<Food> listFoodByBusinessId(Integer businessId);
    List<Food> listFood(Integer businessId,Integer userId);

    Cart getCart(Integer foodId,Integer userId);

    void addFood(Food food);

    void deleteFood(Integer foodId);

}
