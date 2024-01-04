package com.example.elmback.mapper;

import com.example.elmback.pojo.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user where userId = #{userId}")
    User getUserInfo(Integer userId);
    @Select("select * from user where userName=#{userName} and password=#{password}")
    User login(User user);

    @Insert("insert into user(password, userName, userSex, userImg, delTag, name)" +
            "values (#{password}, #{userName}, #{userSex}, #{userImg}, #{delTag}, #{name})")
    void register(User user);

    @Select("select * from orders where userId=#{userId} and orderState = 0")
    List<Orders> getOrdersNotPay(Integer userId);

    @Select("select * from orders where userId=#{userId} and orderState = 1")
    List<Orders> getOrdersPay(Integer userId);
    @Select("select * from business where businessId = #{businessId}")
    Business getBusiness(Integer businessId);

    @Select("select * from orderdetailet where orderId = #{orderId}")
    List<OrderDetailet> getOrderDetailet(Integer orderId);

    @Select("select * from food where foodId = #{foodId}")
    Food getFood(Integer foodId);

    @Select("select * from user where userName = #{userName}")
    User getUserByUserName(String userName);
}
