package com.syscoshop.miniprojectbackend.product;

import com.syscoshop.miniprojectbackend.cart.Cart;
import com.syscoshop.miniprojectbackend.productcategory.ProductCategory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Integer productId;
    @NotEmpty
    private String productName;
    @NotEmpty
    private String productDescription;
    @NotEmpty
    private String productVendor;
    @NotNull
    private float productUnitPrice;
    @NotEmpty
    private String productQuantity;
    private String productImageLinks;
    private Integer productCurrentAvailableAmount;


    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "productCategoryId")
    private ProductCategory productCategory;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_cart",
    joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "productId"),
    inverseJoinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "cartId"))
    private List<Cart> carts;
}
