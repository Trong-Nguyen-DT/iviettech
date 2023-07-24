package com.shop.shoppingmvc.converter;

import com.shop.shoppingmvc.domain.Product;
import com.shop.shoppingmvc.entity.ProductEntity;

public class ProductConverter {
    public static Product toModel(ProductEntity productEntity) {
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setName(productEntity.getName());
        product.setPrice(productEntity.getPrice());
        return product;
    }
    public static ProductEntity toEntity(Product product) {
        ProductEntity entity = new ProductEntity();
        entity.setName(product.getName());
        entity.setPrice(entity.getPrice());
        return entity;
    }
}
