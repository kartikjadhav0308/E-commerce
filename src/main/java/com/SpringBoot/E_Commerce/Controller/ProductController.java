package com.SpringBoot.E_Commerce.Controller;

import com.SpringBoot.E_Commerce.DTO.ProductRequestDTO;
import com.SpringBoot.E_Commerce.DTO.ProductResponseDTO;
import com.SpringBoot.E_Commerce.DTO.UpdateProductDTO;
import com.SpringBoot.E_Commerce.Entity.Product;
import com.SpringBoot.E_Commerce.Services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/getProducts")
    public Product getProduct(){
        return productService.findBy
    }
    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody ProductRequestDTO productRequestDTO){
        return ResponseEntity.ok(productService.add(productRequestDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable Long id , @RequestBody UpdateProductDTO updateProductDTO){
        return ResponseEntity.ok(productService.updatefield(id,updateProductDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        return ResponseEntity.ok(productService.delete(id));
    }
}
