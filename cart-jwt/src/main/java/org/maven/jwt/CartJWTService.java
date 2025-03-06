package org.maven.jwt;

import io.smallrye.jwt.build.Jwt;
import jakarta.inject.Singleton;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Singleton
public class CartJWTService {

    public String generateJWT() {
        Set<String> groups = new HashSet<>(
        Arrays.asList("admin", "writer")
        );
        long duration=System.currentTimeMillis() + 3600;
        return Jwt.issuer("cart-jwt")
                .subject("cart-jwt")
                .groups(groups)
                .expiresAt(duration)
                .sign();
    }
}
