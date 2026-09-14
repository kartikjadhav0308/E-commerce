package com.SpringBoot.E_Commerce.DTO;

import lombok.Data;

import java.util.Set;

@Data
public class ProductRequestDTO {
    private String productName;
    private double price;
    private float discount;
    private String imgURL;
    private Set<String> categoryNames;
}
