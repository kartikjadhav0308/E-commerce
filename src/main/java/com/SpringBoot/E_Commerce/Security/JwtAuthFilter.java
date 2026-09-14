package com.SpringBoot.E_Commerce.Security;

import com.SpringBoot.E_Commerce.Entity.Signup;
import com.SpringBoot.E_Commerce.Repository.SignupRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private final SignupRepository userRepo;
    private final AuthUtil authUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String requestTokenHeader=request.getHeader("Authorization");

        if(requestTokenHeader == null || !requestTokenHeader.startsWith("Bearer")){
            filterChain.doFilter(request,response);
            return;
        }

        String token = requestTokenHeader.substring(7).trim();

        String username = authUtil.getUsernameFromToken(token);


        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            Signup user = userRepo.findByUsername(username).orElseThrow();

            UsernamePasswordAuthenticationToken token1 = new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(token1);

        }

        filterChain.doFilter(request, response);
    }
}
