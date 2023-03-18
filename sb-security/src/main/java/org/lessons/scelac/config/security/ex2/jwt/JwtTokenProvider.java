package org.lessons.scelac.config.security.ex2.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.lessons.scelac.config.security.CustomUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * @author scelac
 */
@Component
public class JwtTokenProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    private final String jwtSecret = "myVeryVerySecretPrivateYyJpZCI6MSwiZmlyc3ROYW1lIjoiSm9uIiwibGFzdE5hbWUiOiJqb24uZGF2aXNAZ21";
    private static final Duration JWT_TOKEN_VALIDITY = Duration.ofDays(365);
    //in case if principal are not cast correct fetch  from  db user by  email

    public String generateToken(Authentication authentication){
            final CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        Claims claims = Jwts.claims();
        claims.put("id", customUserDetails.getId());
        claims.put("username", customUserDetails.getUsername());
        claims.put("firstName", customUserDetails.getFirstName());
        claims.put("lastName", customUserDetails.getLastName());
        claims.put("roles", customUserDetails.getAuthorities().stream().map(Object::toString).collect(Collectors.toList()));
        final Instant now = Instant.now();


        return Jwts.builder().setClaims(claims)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plusMillis(JWT_TOKEN_VALIDITY.toMillis())))
                .signWith(SignatureAlgorithm.HS512, jwtSecret.getBytes(StandardCharsets.UTF_8))
                .compact();
    }

    public String getUserNameFromJWT(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret.getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token)
                .getBody();
        return claims.get("username").toString();
    }

  public Collection<GrantedAuthority> getUserRolesFromJWT(String token) {
    Claims claims = Jwts.parser().setSigningKey(jwtSecret.getBytes(StandardCharsets.UTF_8)).parseClaimsJws(token).getBody();

    @SuppressWarnings("unchecked")
    ArrayList<String> roles = (ArrayList<String>) claims.get("roles", ArrayList.class);
    return roles.stream()
        .map(authority -> new SimpleGrantedAuthority(authority))
        .collect(Collectors.toList());
        }
    boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret.getBytes(StandardCharsets.UTF_8)).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;
    }
}
