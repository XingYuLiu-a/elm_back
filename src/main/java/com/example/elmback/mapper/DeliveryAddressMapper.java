package com.example.elmback.mapper;

import com.example.elmback.pojo.DeliveryAddress;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeliveryAddressMapper {
    @Select("select * from deliveryaddress where userId = #{userId}")
    List<DeliveryAddress> list(Integer userId);

    @Insert("insert into deliveryaddress(contactName, contactSex, contactTel, address, userId) values (#{contactName}, #{contactSex}, #{contactTel}, #{address}, #{userId})")
    void addAddress(DeliveryAddress deliveryAddress);

    @Delete("delete from deliveryaddress where daId=#{daId}")
    void deleteAddress(Integer daId);

    void updateAddress(DeliveryAddress deliveryAddress);

    @Select("select * from deliveryaddress where daId = #{daId}")
    DeliveryAddress getByDaId(Integer daId);
}
