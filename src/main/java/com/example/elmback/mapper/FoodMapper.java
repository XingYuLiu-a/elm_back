package com.example.elmback.mapper;

import com.example.elmback.pojo.Cart;
import com.example.elmback.pojo.Food;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FoodMapper {

    @Select("select * from food where businessId=#{businessId}")
    List<Food> listFoodByBusiness(Integer businessId);

    @Select("select * from food where businessId=#{businessId}")
    List<Food> listFood(Integer businessId,Integer userId);

    @Insert("insert into food(foodName, foodExplain, foodImg, foodPrice, businessId, remarks)" +
            "values (#{foodName}, #{foodExplain}, #{foodImg}, #{foodPrice}, #{businessId}, #{remarks})")
    void addFood(Food food);

    @Select("select * from cart where foodId=#{foodId} and userId = #{userId}")
    Cart getCard(Integer foodId,Integer userId);

    @Select("select quantity from cart where foodId=#{foodId} and userId = #{userId}")
    Integer getQuantity(Integer foodId,Integer userId);

    @Select("select cartId from cart where foodId=#{foodId} and userId = #{userId}")
    Integer getCartId(Integer foodId,Integer userId);


    @Delete("delete from food where foodId=#{foodId}")
    void deleteFood(Integer foodId);
}
