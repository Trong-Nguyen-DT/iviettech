package com.shop.shoppingmvc.converter;

import com.shop.shoppingmvc.domain.CartItem;
import com.shop.shoppingmvc.domain.Product;
import com.shop.shoppingmvc.entity.ProductEntity;

public class CartConverter {
    public static ProductEntity toEntity(CartItem cartItem) {
        ProductEntity product = new ProductEntity();
        product.setName(cartItem.getProduct().getName());
        product.setPrice(cartItem.getProduct().getPrice());
        return product;
    }
}
