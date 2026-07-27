package in.amold.jwthandson.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;



@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretkey;


    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(secretkey.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(UserDetails user) {

        return Jwts.builder()
                 .subject(user.getUsername())
                 .issuedAt(new Date())
                 .expiration(new Date(System.currentTimeMillis() + 1000 * 15 * 60))
                 .signWith(getSecretKey())
                 .compact();
    }

    public String getUsername(String token) {
        return Jwts.parser().verifyWith(getSecretKey()).build().parseSignedClaims(token).getPayload().getSubject();
    }

}
