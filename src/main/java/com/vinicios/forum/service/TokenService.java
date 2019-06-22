package com.vinicios.forum.service;

import com.vinicios.forum.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${forum.jwt.expiration}")
    private String expirationTime;

    @Value("${forum.jwt.secret}")
    private String secret;

    public String generateToken(Authentication authentication) {
        User logged = (User) authentication.getPrincipal();
        Date today = new Date();
        Date exprirationDate = new Date(today.getTime() + Long.parseLong(expirationTime));

        return Jwts.builder()
                .setIssuer("Forum API")
                .setSubject(logged.getId().toString())
                .setIssuedAt(today)
                .setExpiration(exprirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

}
