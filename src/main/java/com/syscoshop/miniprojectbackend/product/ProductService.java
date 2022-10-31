package com.syscoshop.miniprojectbackend.product;

import java.util.List;

public interface ProductService {
    public void addProduct(Product product);

    public void deleteProduct(int productId);

    public List<Product> getAllProducts();

    public List<Product> getProductsByCategory(int productCategoryId);

    public void getProductByName(String productName);

    public void updateProduct(int productId);
}
