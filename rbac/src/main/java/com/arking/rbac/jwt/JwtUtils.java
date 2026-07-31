package com.arking.rbac.jwt;

import com.arking.rbac.model.Employee;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtils {

    @Value("${app.jwt.secret}")
    private String jwtSecret;


    @Value("${app.jwt.access-token-expiration-ms}")
    private long accessTokenExpire;


    @Value("${app.jwt.refresh-token-expiration-ms}")
    private long refreshTokenExpire;

    private SecretKey getSigningKey(){
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    // extraction

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimResolver){
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    public Claims extractAllClaims(String token){
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }



    // generation or generate

    public String generateAccessToken(Employee employee){
        return generateAccessToken(new HashMap<>(), employee);
    }

    public String generateAccessToken(Map<String, Object> extraClaims, Employee employee){
        return buildToken(extraClaims, employee.getUsername(), accessTokenExpire);
    }

    public String generateRefreshToken(Employee employee){
        return buildToken(new HashMap<>(), employee.getUsername(), refreshTokenExpire);
    }


    public String buildToken(Map<String, Object> extraClaims, String username, long expiration){
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);


        return Jwts.builder()
                .claims(extraClaims)
                .subject(username)
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(getSigningKey())
                .compact();
    }

    // validation

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    public  Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }
}
