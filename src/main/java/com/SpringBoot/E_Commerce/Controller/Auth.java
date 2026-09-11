package com.SpringBoot.E_Commerce.Controller;

import com.SpringBoot.E_Commerce.DTO.LoginRequestDTO;
import com.SpringBoot.E_Commerce.DTO.LoginResponseDTO;
import com.SpringBoot.E_Commerce.Security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class Auth {
    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO){
        return authService.login(loginRequestDTO);
    }
}
