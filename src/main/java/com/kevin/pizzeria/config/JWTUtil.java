package com.kevin.pizzeria.config;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {

    private static final String KEY = "kevin";

    // public String generarToken(UserDetails userDetails) {
    //     return Jwts
    //             .builder()
    //             .setSubject(userDetails.getUsername())
    //             .setIssuedAt(new Date())
    //             .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
    //             .signWith(SignatureAlgorithm.HS256, KEY).compact();
    // }

}
