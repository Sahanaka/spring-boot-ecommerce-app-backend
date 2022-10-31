package com.syscoshop.miniprojectbackend.productcategory;

import com.syscoshop.miniprojectbackend.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public void createProductCategory(ProductCategoryCreateDto productCategoryCreateDto) {
        ProductCategory productCategory = ProductCategory
                .builder()
                .title(productCategoryCreateDto.productCategoryTitle)
                .subCategory(productCategoryCreateDto.productCategorySubtitle)
                .build();
        productCategoryRepository.save(productCategory);
    }

    @Override
    public void removeExistingProductCategory(int productCategoryId) {
        productCategoryRepository.deleteById(productCategoryId);
    }

    @Override
    public ProductCategory getProductCategory(int productCategoryId) {
        return productCategoryRepository
                .findById(productCategoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Product category cannot be found", productCategoryId));
    }

    @Override
    public List<ProductCategory> getAllProductCategories() {
        return productCategoryRepository.findAll();
    }
}
