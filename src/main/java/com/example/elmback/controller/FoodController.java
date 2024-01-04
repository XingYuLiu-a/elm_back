package com.example.elmback.controller;

import com.example.elmback.pojo.Cart;
import com.example.elmback.pojo.Food;
import com.example.elmback.pojo.Result;
import com.example.elmback.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping("/food/businessId/{businessId}")
    public Result listFoodByBusinessId(@PathVariable Integer businessId){
        List<Food> foodList = foodService.listFoodByBusinessId(businessId);
        return Result.success(foodList);
    }

    @GetMapping("/food/{businessId}/{userId}")
    public Result listFood(@PathVariable Integer businessId,@PathVariable Integer userId){
        List<Food> foodList = foodService.listFood(businessId,userId);
        return Result.success(foodList);
    }

    @GetMapping("/food/getCart/{foodId}/{userId}")
    public Result getCart(@PathVariable Integer foodId,@PathVariable Integer userId){
        Cart cart = foodService.getCart(foodId,userId);
        return Result.success(cart);
    }

    @PostMapping("/food")
    public Result addFood(@RequestBody Food food){
        foodService.addFood(food);
        return Result.success();
    }
    @DeleteMapping("/food/{foodId}")
    public Result deleteFood(@PathVariable Integer foodId){
       foodService.deleteFood(foodId);
        return Result.success();
    }

}
