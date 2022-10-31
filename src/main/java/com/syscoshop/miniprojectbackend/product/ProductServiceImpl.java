package com.syscoshop.miniprojectbackend.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public void addProduct(Product product) {
        productRepository.saveAndFlush(product);
    }

    public void deleteProduct(int productId) {}

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(int productCategoryId) {
        return productRepository
                .findAll()
                .stream()
                .filter(product -> product.getProductCategory().getProductCategoryId() == productCategoryId)
                .collect(Collectors.toList());
    }

    public void getProductByName(String productName) {}

    public void updateProduct(int productId) {}
}
