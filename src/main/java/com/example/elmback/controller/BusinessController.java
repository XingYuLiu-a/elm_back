package com.example.elmback.controller;

import com.example.elmback.pojo.Business;
import com.example.elmback.pojo.Result;
import com.example.elmback.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    @GetMapping("/business")
    public Result list(){
        List<Business> bussinessList = businessService.list();
        return Result.success(bussinessList);
    }
    @GetMapping("/business/search/{name}")
    public Result search(@PathVariable String  name){
        List<Business> businessList = businessService.search(name);
        return Result.success(businessList);
    }
    @GetMapping("/business/orderTypeId/{orderTypeId}")
    public Result getByOrderTypeId(@PathVariable Integer orderTypeId){
        List<Business> businessList = businessService.getByOrderTypeId(orderTypeId);
        return Result.success(businessList);
    }

    @GetMapping("/business/businessId/{businessId}")
    public Result getByBusinessId(@PathVariable Integer businessId){
        Business business = businessService.getByBusinessId(businessId);
        return Result.success(business);
    }

    @PostMapping("/business")
    public Result add(@RequestBody Business business) {
        businessService.add(business);
        // 返回成功的结果
        return Result.success();
    }
    @DeleteMapping("/business/{businessId}")
    public Result delete(@PathVariable Integer businessId){
        businessService.delete(businessId);
        return Result.success();
    }

    @GetMapping("/business/total/{businessId}/{userId}")
    public Result total(@PathVariable Integer businessId,@PathVariable Integer userId){
        Double total =  businessService.total(businessId,userId);
        return Result.success(total);
    }
    @GetMapping("/business/quantity/{businessId}/{userId}")
    public Result quantity(@PathVariable Integer businessId,@PathVariable Integer userId){
        Integer quantity = businessService.getQuantity(businessId,userId);
        return Result.success(quantity);
    }


}
