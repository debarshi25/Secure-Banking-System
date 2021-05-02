package edu.asu.cse545.group5.SBS.util;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {
    
    private String SECRET_KEY = "Group5ApplicationKey";
    
    public String extractUsernameFromToken(String token) {
        return extractClaim(token, Claims::getSubject);
    }
    
    public Date extractExpirationFromToken(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Boolean isTokenExpired(String token) {
        return extractExpirationFromToken(token).before(new Date());
    }

    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    } 

    public Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
   
    public String generateJWTToken(UserDetails userDetails) {
       Map <String, Object> claims = new HashMap<>();
       return createJWTToken(claims, userDetails.getUsername());
    }
    
    private String createJWTToken(Map <String, Object> claims, String subject) {
       return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
       .setExpiration(new Date(System.currentTimeMillis() + 1000*60*30)).signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public Boolean validateJWTToken(String token, UserDetails userDetails) {
        final String username = extractUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
