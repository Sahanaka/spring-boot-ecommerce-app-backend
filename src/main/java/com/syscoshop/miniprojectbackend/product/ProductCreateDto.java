package com.syscoshop.miniprojectbackend.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductCreateDto {
    private String productName;
    private String productDescription;
    private String productVendor;
    private float productUnitPrice;
    private String productQuantity;
    private String productImageLinks;
    private Integer productCurrentAvailableAmount;
    private Integer productCategoryId;
}
