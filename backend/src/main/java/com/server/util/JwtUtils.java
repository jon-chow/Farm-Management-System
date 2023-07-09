package com.server.util;

import io.jsonwebtoken.*;

import java.util.Date;

public class JwtUtils {
    private static final String SECRET_KEY = "4BC52ADD35887A9873E7C2E42145C";

    /**
     * Generates a JWT token with SECRET_KEY
     * @param subject
     * @return
     *      a JWT token
     */
    public static String generateToken(String subject) {
        long expirationTimeMillis = 3600000; // 1 hour

        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTimeMillis))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    /**
     * Validates a token
     * @param token
     * @return
     *      true - if the token is valid.
     *      false - if the token is invalid.
     */
    public static boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
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
