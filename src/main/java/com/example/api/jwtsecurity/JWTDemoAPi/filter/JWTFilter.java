package com.example.api.jwtsecurity.JWTDemoAPi.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {

    @Value("${app.jwt.auth.path}")
    private String authPath;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("Passing from JWTFilter filter");
        System.out.println("Request URL: " + request.getRequestURI());

        if (!request.getRequestURI().contains(authPath) && request.getHeader("Authorization") == null) {
            response.sendError(401, "Request is not allowed because the JWT token was no sent");
        }

        filterChain.doFilter(request, response);
    }
}
