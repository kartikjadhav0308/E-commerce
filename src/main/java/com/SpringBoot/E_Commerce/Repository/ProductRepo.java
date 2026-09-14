package com.SpringBoot.E_Commerce.Repository;

import com.SpringBoot.E_Commerce.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
}
