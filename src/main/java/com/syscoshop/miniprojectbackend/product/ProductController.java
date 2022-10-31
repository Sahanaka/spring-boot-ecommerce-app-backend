package com.syscoshop.miniprojectbackend.product;

import com.syscoshop.miniprojectbackend.productcategory.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {
    private final ProductService productService;

    private final ProductCategoryRepository productCategoryRepository;

    private final ModelMapper modelMapper;

    @GetMapping
    public List<ProductReturnDto> getAllProducts() {
        return productService
                .getAllProducts()
                .stream()
                .map(product -> convertEntityToDto(product))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "{productCategoryId}")
    public List<ProductReturnDto> getAllProductsFilteredByCategory(@PathVariable("productCategoryId") int productCategoryId) {
        return productService
                .getProductsByCategory(productCategoryId)
                .stream()
                .map(product -> convertEntityToDto(product))
                .collect(Collectors.toList());
    }

    @PostMapping
    public void addNewProduct(@Valid @RequestBody ProductCreateDto productCreateDto) throws ParseException {
        Product newProduct = convertDtoToProductEntity(productCreateDto);
        productService.addProduct(newProduct);
    }

    private Product convertDtoToProductEntity(ProductCreateDto productCreateDto) throws ParseException {
        Product mappedProduct = modelMapper.map(productCreateDto, Product.class);
        productCategoryRepository
                .findById(productCreateDto.getProductCategoryId())
                .ifPresent(mappedProduct::setProductCategory);
        return mappedProduct;
    }

    private ProductReturnDto convertEntityToDto(Product product) {
        ProductReturnDto productReturnDto = modelMapper.map(product, ProductReturnDto.class);
        return productReturnDto;
    }
}
