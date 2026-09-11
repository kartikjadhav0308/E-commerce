package com.SpringBoot.E_Commerce.Security;

import com.SpringBoot.E_Commerce.Entity.Signup;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Controller
public class AuthUtil {
    @Value("${jwt.secretkey}")
    private String jwtSecretKey;

    private SecretKey getJwtSecretKey(){
        return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));

    }
    public String generateToken(Signup user) {
              return Jwts.builder()
                      .subject(user.getUsername())
                      .claim("userID",user.getId())
                      .issuedAt(new Date())
                      .expiration(new Date(System.currentTimeMillis()+(1000*60*10)))
                      .signWith(getJwtSecretKey())
                      .compact();
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(getJwtSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getSubject();
    }
}
