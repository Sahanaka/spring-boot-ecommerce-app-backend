package com.syscoshop.miniprojectbackend.productcategory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductCategoryCreateDto {
    public String productCategoryTitle;
    public String productCategorySubtitle;
}
