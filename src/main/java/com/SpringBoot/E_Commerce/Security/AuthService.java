package com.SpringBoot.E_Commerce.Security;

import com.SpringBoot.E_Commerce.DTO.LoginRequestDTO;
import com.SpringBoot.E_Commerce.DTO.LoginResponseDTO;
import com.SpringBoot.E_Commerce.Entity.Signup;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;

    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequestDTO.getUsername(),
                                loginRequestDTO.getPassword()
                        )
                );

        if (authentication == null) {
            throw new IllegalStateException(
                    "AuthenticationManager returned null"
            );
        }

        Signup user = (Signup) authentication.getPrincipal();

        String token = authUtil.generateToken(user);

        return new LoginResponseDTO(token, user.getId());
    }
}
