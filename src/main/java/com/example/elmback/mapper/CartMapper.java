package com.example.elmback.mapper;

import com.example.elmback.pojo.Cart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CartMapper {
    @Insert("insert into cart(foodId, businessId, userId, quantity)" +
            "values(#{foodId}, #{businessId}, #{userId}, #{quantity})")
    void addCart(Cart cart);

    @Update("update cart set quantity = quantity + 1 " +
            "where cartId=#{cartId}")
    void addQuantity(Integer cartId);

    @Update("update cart set quantity = quantity - 1 " +
            "where cartId=#{cartId}")
    void substrateQuantity(Integer cartId);

    @Select("select quantity from cart where cartId = #{cartId}")
    Integer getCartQuantity(Integer cartId);

    @Update("update cart set quantity = 0 " +
            "where cartId=#{cartId}")
    void setQuantity(Integer cartId);
}
