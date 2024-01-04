package com.example.elmback;

import com.example.elmback.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;

@SpringBootTest
class ElmBackApplicationTests {

    @Test
    public void test1(){
        JwtUtils jwtUtils = new JwtUtils();
        HashMap<String,Object> map = new HashMap<>();
        map.put("id",1);
        map.put("userName","大蒜");
        map.put("perms", Arrays.asList("p1","p2","p3"));
        String  token = jwtUtils.createToken(map);
        System.out.println("token======>"+token);
    }

    @Test
    public void test2(){
        JwtUtils jwtUtils = new JwtUtils();
        Claims claims = jwtUtils.parseToken("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoi5Lq65a6H6IiqIiwidXNlck5hbWUiOiJ5dWhhbmcxIiwiZXhwIjoxNzAyOTAzMTI3LCJ1c2VySWQiOjMsImlhdCI6MTcwMjkwMTMyN30.e-wEcjPlSygZp8JHgcsonixI1HkfQH6-6TN1IaY0Wz4");
        System.out.println("claims======>"+claims);
    }

}
