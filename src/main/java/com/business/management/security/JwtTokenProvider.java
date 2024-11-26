package com.business.management.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;
import java.util.Date;
import java.security.Key;


@Component
public class JwtTokenProvider {
    @Value("${app.jwt-secret}")
    private String jwtSecretKey;

    // Generate JWT token
    public String generateToken(Authentication authentication) {
        // Token validity duration (e.g., 10 hours)
        // 10 hours
        long validityInMilliseconds = 10 * 60 * 60 * 1000;
        return Jwts.builder()
                .subject(authentication.getName())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + validityInMilliseconds))
                .signWith(key())
                .compact();
    }
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith((SecretKey) key())
                    .build()
                    .parse(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecretKey));
    }

    // Extract username from JWT token
    public String extractUsername(String token) {
        return Jwts.parser()
                .verifyWith((SecretKey) key() )
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

}
