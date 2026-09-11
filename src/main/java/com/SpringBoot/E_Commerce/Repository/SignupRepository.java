package com.SpringBoot.E_Commerce.Repository;

import com.SpringBoot.E_Commerce.Entity.Signup;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface SignupRepository extends JpaRepository<Signup, Long> {
    Optional<Signup> findByUsername(String username);

    boolean existsByUsername(String username);
}