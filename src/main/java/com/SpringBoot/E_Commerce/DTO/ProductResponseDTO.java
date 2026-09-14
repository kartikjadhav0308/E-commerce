package com.SpringBoot.E_Commerce.DTO;

import lombok.Data;

@Data
public class ProductResponseDTO {
    private String productName;
    private double price;
    private float discount;
    private String imgURL;
}
