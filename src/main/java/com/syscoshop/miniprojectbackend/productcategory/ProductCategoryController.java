package com.syscoshop.miniprojectbackend.productcategory;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/product-categories")
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;

    @GetMapping
    public List<ProductCategory> getAllProductCategories() {
        return productCategoryService.getAllProductCategories();
    }

    @GetMapping(path = "{productCategoryId}")
    public ProductCategory getProductCategory(@PathVariable("productCategoryId")
                                                            int productCategoryId) {
        return productCategoryService.getProductCategory(productCategoryId);
    }

    @PostMapping
    public void createProductCategory(@Valid @RequestBody ProductCategoryCreateDto productCategoryCreateDto) {
        productCategoryService.createProductCategory(productCategoryCreateDto);
    }

    @DeleteMapping(path = "{productCategoryId}")
    public void deleteProductCategory(@PathVariable("productCategoryId") int id) {
        productCategoryService.removeExistingProductCategory(id);
    }
}
