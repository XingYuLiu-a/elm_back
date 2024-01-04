package com.example.elmback.mapper;

import com.example.elmback.pojo.Business;
import com.example.elmback.pojo.Cart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BusinessMapper {
    @Select("select * from business")
    List<Business> list();
    @Select("select * from business where businessName like concat('%',#{name},'%')")
    List<Business> search(String name);

    @Select("select * from business where orderTypeId = #{orderTypeId}")
    List<Business> getByOrderTypeId(Integer orderTypeId);

    @Select("select * from business where businessId=#{businessId}")
    Business getByBusinessId(Integer businessId);

    @Insert("insert into business" +
            "(businessName, businessAddress, businessExplain, businessImg, orderTypeId, starPrice, deliveryPrice, remarks)" +
            "values " +
            "(#{businessName}, #{businessAddress}, #{businessExplain},#{businessImg},#{orderTypeId},#{starPrice},#{deliveryPrice},#{remarks})")
    void add(Business business);

    @Delete("delete from business where businessId = #{businessId}")
    void deleteBusiness(Integer businessId);

    @Delete("delete from food where businessId = #{businessId}")
    void deleteFood(Integer businessId);

    @Select("select * from cart where businessId=#{businessId} and userId = #{userId} and quantity != 0")
    List<Cart> getCartByBusiness(Integer businessId,Integer userId);

    @Select("select foodPrice from food where foodId=#{foodId}")
    Double getPrice(Integer foodId);
}
