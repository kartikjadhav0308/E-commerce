package com.SpringBoot.E_Commerce.Controller;

import com.SpringBoot.E_Commerce.DTO.CategoryDTO;
import com.SpringBoot.E_Commerce.Services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping("/add")
    public ResponseEntity<String> addCategory(@RequestBody CategoryDTO categoryDTO){
        return ResponseEntity.ok(categoryService.save(categoryDTO));
    }
}
