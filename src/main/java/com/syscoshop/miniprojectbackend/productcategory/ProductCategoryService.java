package com.syscoshop.miniprojectbackend.productcategory;

import java.util.List;

public interface ProductCategoryService {
    void createProductCategory(ProductCategoryCreateDto productCategoryCreateDto);

    void removeExistingProductCategory(int productCategoryId);

    ProductCategory getProductCategory(int productCategoryId);

    List<ProductCategory> getAllProductCategories();
}
