package com.SpringBoot.E_Commerce.Services;

import com.SpringBoot.E_Commerce.DTO.SignupDTO;
import com.SpringBoot.E_Commerce.Entity.Signup;
import com.SpringBoot.E_Commerce.Enumerate.RoleEnum;
import com.SpringBoot.E_Commerce.Repository.SignupRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {
    private final SignupRepository signupRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    public String add(SignupDTO signupDTO) {
        if (signupRepository.existsByUsername(signupDTO.getUsername())) {
            return "Username already exists";
        }

        try {
            Signup signup = new Signup()
                    .builder()
                    .username(signupDTO.getUsername())
                    .password(passwordEncoder.encode(signupDTO.getPassword()))
                    .role(RoleEnum.USER)
                    .build();
            signupRepository.save(signup);
            return "Signup Successfully";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public String addSeller(SignupDTO signupDTO) {
        if(signupRepository.existsByUsername(signupDTO.getUsername())){
            return "Username already exists";
        }
        try{
            Signup signup = new Signup()
                    .builder()
                    .username(signupDTO.getUsername())
                    .password(passwordEncoder.encode(signupDTO.getUsername()))
                    .role(RoleEnum.SELLER)
                    .build();
            return "Signup of seller successfully";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
