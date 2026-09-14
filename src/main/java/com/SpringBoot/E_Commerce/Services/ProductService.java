package com.SpringBoot.E_Commerce.Services;
import com.SpringBoot.E_Commerce.DTO.ProductRequestDTO;
import com.SpringBoot.E_Commerce.DTO.ProductResponseDTO;
import com.SpringBoot.E_Commerce.DTO.UpdateProductDTO;
import com.SpringBoot.E_Commerce.Entity.Category;
import com.SpringBoot.E_Commerce.Entity.Product;
import com.SpringBoot.E_Commerce.Repository.CategoryRepo;
import com.SpringBoot.E_Commerce.Repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;
    private final ModelMapper modelMapper;
    private final CategoryRepo categoryRepository;


    public Product add(ProductRequestDTO productRequestDTO) {
        Product product = modelMapper.map(productRequestDTO,Product.class);
        List<Category> categoryList =
                categoryRepository.findByCategoryNameIn(productRequestDTO.getCategoryNames());

        if (categoryList.size() != productRequestDTO.getCategoryNames().size()) {
            throw new RuntimeException("One or more categories do not exist");
        }
        product.setCategories(new HashSet<>(categoryList));

        return productRepo.save(product);
    }


    public ProductResponseDTO updatefield(Long id, UpdateProductDTO updateProductDTO) {
        Product product = productRepo.findById(id).orElseThrow(()->new RuntimeException());

        switch(updateProductDTO.getField()){
            case "productName":
                product.setProductName(updateProductDTO.getValue());
                break;

            case "price":
                product.setPrice(Double.parseDouble(updateProductDTO.getValue()));
                break;

            case "discount":
                product.setDiscount(Float.parseFloat(updateProductDTO.getValue()));
                break;

            case "imgURL":
                product.setImgURL(updateProductDTO.getValue());
                break;

            default:
                throw new RuntimeException("Invalid field");
        }
        Product updateProduct = productRepo.save(product);
        return modelMapper.map(updateProduct, ProductResponseDTO.class);
        }


    public String delete(Long id) {
        if(!productRepo.existsById(id)){
            return "Product not found";
        }
        productRepo.deleteById(id);
        return "delete successfully";
    }
}

