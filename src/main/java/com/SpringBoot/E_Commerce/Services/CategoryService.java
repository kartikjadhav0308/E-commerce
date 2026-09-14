package com.SpringBoot.E_Commerce.Services;

import com.SpringBoot.E_Commerce.DTO.CategoryDTO;
import com.SpringBoot.E_Commerce.Entity.Category;
import com.SpringBoot.E_Commerce.Repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepo categoryRepo;
    private final ModelMapper modelMapper;

    public String save(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO,Category.class);
        categoryRepo.save(category);
        return "Category add successfully";
    }
}
