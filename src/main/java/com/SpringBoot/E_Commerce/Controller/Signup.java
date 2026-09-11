package com.SpringBoot.E_Commerce.Controller;

import com.SpringBoot.E_Commerce.DTO.SignupDTO;
import com.SpringBoot.E_Commerce.Services.SignupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
@RequiredArgsConstructor
public class Signup {
    private final SignupService signupService;
    @PostMapping("/")
    public ResponseEntity<String> signup(@Valid @RequestBody SignupDTO signupDTO){
        return ResponseEntity.ok(
                signupService.add(signupDTO)
        );
    }

    @PostMapping("/seller/add")
    public ResponseEntity<String> signupSeller(@Valid @RequestBody SignupDTO signupDTO){
        return ResponseEntity.ok(
                signupService.addSeller(signupDTO)
        );
    }

}
