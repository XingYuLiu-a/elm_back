package com.example.elmback.utils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtUtils {

    private String key = "elmshixun";


    /**
     * 生成JWT令牌
     */
    public String createToken(Map<String,Object> map){
        String token = Jwts.builder()
                .setClaims(map)
                //颁发时间
                .setIssuedAt(new Date())
                //过期时间
                .setExpiration(new Date(System.currentTimeMillis() + 30 * 60 * 1000))
                //加密算法
                .signWith(SignatureAlgorithm.HS256,key)
                .compact();
        return token;
    }

    /**
     * 解析JWT令牌
     */
    public Claims parseToken(String token){
        Claims claims = Jwts.parser().setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }
}
