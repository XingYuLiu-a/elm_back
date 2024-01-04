package com.example.elmback.service.impl;

import com.example.elmback.mapper.FoodMapper;
import com.example.elmback.pojo.Cart;
import com.example.elmback.pojo.Food;
import com.example.elmback.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodMapper foodMapper;

    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {
        List<Food> foodList = foodMapper.listFoodByBusiness(businessId);
        for (Food food : foodList){
            Cart newCart = new Cart();
            newCart.setQuantity(0);
            food.setCart(newCart);
        }
        return foodList;
    }

    @Override
    public List<Food> listFood(Integer businessId,Integer userId) {
            List<Food> foodList =foodMapper.listFood(businessId,userId);
            for(Food food :foodList){
                Cart newCart = new Cart();
                newCart.setQuantity(foodMapper.getQuantity(food.getFoodId(),userId));
                newCart.setCartId(foodMapper.getCartId(food.getFoodId(),userId));
                newCart.setFoodId(food.getFoodId());
                newCart.setBusinessId(businessId);
                newCart.setUserId(userId);
                food.setCart(newCart);
            }
            return foodList;
    }

    @Override
    public Cart getCart(Integer foodId,Integer userId) {
        return foodMapper.getCard(foodId,userId);
    }

    @Override
    public void addFood(Food food) {
        foodMapper.addFood(food);
    }

    @Override
    public void deleteFood(Integer foodId) {
        foodMapper.deleteFood(foodId);
    }

}
