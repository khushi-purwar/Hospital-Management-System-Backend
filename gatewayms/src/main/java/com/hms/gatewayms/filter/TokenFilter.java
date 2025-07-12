package com.hms.gatewayms.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class TokenFilter extends AbstractGatewayFilterFactory<TokenFilter.Config> {

    private static final String SECRET_KEY = "400aa17bb14ae386023cff006e729dc8bdb4c2dbb4de13a8d30553c94c465215208438c4e16d3ee9ef4e93eb6457cae109753d13111387e39c59de40f10118f6";

    public TokenFilter(){
        super(Config.class);
    }

    public static class Config{ 

    } 

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            String path = exchange.getRequest().getPath().toString();
            if(path.equals("/user/login") || path.equals("/user/register") ){
                return chain.filter(exchange.mutate().request(req->req.header("X-Secret-Key", "SECRET")).build());
            }

            HttpHeaders headers = exchange.getRequest().getHeaders();
            if(!headers.containsKey("Authorization")){
                throw new RuntimeException("Authorization header is missing!");
            }

            String authHeader = headers.getFirst(HttpHeaders.AUTHORIZATION);
            if(authHeader == null || !authHeader.startsWith("Bearer ")){
                throw new RuntimeException("Invalid Authorization header format!");
            }

            String token = authHeader.substring(7); // Extract the token after "Bearer " 
            try {
                Claims claims = Jwts.parser()
                        .setSigningKey(SECRET_KEY)
                        .build()
                        .parseClaimsJws(token)
                        .getBody();
                exchange  = exchange.mutate().request(req->req.header("X-Secret-Key", "SECRET")).build();
            } catch (Exception e) {
                throw new RuntimeException("Invalid token!");
            }

            return chain.filter(exchange);
        };
    }

}
