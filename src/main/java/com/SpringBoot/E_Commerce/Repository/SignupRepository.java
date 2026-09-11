package com.SpringBoot.E_Commerce.Repository;

import com.SpringBoot.E_Commerce.Entity.Signup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignupRepository extends JpaRepository<Signup, Long> {
    boolean existsByUsername(String username);
}