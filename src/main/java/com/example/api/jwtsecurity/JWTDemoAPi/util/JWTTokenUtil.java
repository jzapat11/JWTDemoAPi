package com.example.api.jwtsecurity.JWTDemoAPi.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component()
public class JWTTokenUtil {

    public static final int EXPIRATION_DATE = (24 * 60 * 60 * 1000); //24 hours valid token.

    @Value("${app.jwt.secret}")
    private String JWT_SECRET;

    public String getJWT(){
        return Jwts.builder()
                .setSubject("Some subject")
                .setIssuedAt(new Date())
                .setIssuer("juan.zapata")
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_DATE))
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }
}
