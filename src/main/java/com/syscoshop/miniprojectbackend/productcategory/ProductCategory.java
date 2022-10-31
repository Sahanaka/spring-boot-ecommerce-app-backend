package com.syscoshop.miniprojectbackend.productcategory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductCategory {
    @Id
    @GeneratedValue
    private Integer productCategoryId;
    @NotEmpty
    private String title;
    @NotEmpty
    private String subCategory;
}
