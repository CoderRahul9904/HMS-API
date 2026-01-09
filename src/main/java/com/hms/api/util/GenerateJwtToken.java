package com.hms.api.util;

import com.hms.api.dto.user.CreateUserDto;
import com.hms.api.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;


public class GenerateJwtToken {

    @Value("${jwt.secretKey}")
    private String jwtSecret;

    public SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
    }


    public String generateJwtToken(User user) {
            return Jwts.builder()
                    .subject(user.getUsername())
                    .claim("userId", user.getId())
                    .issuedAt(new Date())
                    .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10))
                    .signWith(getSecretKey())
                    .compact();
    }
}
