package com.server.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.util.Date;

public class JwtUtils {

    // Generate a secure key for HS256
    static byte[] keyBytes = Keys.secretKeyFor(SignatureAlgorithm.HS256).getEncoded();


    /**
     * Generates a JWT token with SECRET_KEY
     * @param subject
     *      to generate the token with.
     * @return
     *      a JWT token
     */
    public static String generateToken(String subject) {
        long expirationTimeMillis = 3600000; // 1 hour

        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTimeMillis))
                .signWith(SignatureAlgorithm.HS256, keyBytes)
                .compact();
    }

    /**
     * Validates a token
     * @param token
     *      token contained within API request body
     * @return
     *      true - if the token is valid.
     *      false - if the token is invalid.
     */
    public static boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(keyBytes)
                    .build()
                    .parseClaimsJws(token);

            // Additional validations if needed

            return true; // Token is valid
        } catch (JwtException e) {
            // Invalid token (verification failed)
            return false;
        }
    }
}
