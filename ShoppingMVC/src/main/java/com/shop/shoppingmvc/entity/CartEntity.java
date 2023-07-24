package com.shop.shoppingmvc.entity;

import com.shop.shoppingmvc.converter.ProductConverter;
import com.shop.shoppingmvc.domain.CartItem;
import com.shop.shoppingmvc.domain.Product;
import com.shop.shoppingmvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartEntity implements Serializable {
    @Autowired
    private ProductRepository productRepository;
    private final Map<Integer, Integer> productEntities = new HashMap<>();

    public void addItem(int productId) {
        ProductEntity productEntity = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm"));
        count(productEntity);
    }

    public void removeItem(int id) {
        int quantity = productEntities.getOrDefault(id, 0);
        if (quantity > 1) {
            productEntities.put(id, quantity - 1);
        } else {
            productEntities.remove(id);
        }
    }
    public int count(ProductEntity productEntity) {
        int productId = productEntity.getId();
        int quantity = productEntities.getOrDefault(productId, 0);
        productEntities.put(productId, quantity + 1);
        return productEntities.size();
    }
    public void emptyCart() {
        productEntities.clear();
    }

    public List<CartItem> getAllCartItems() {
        List<CartItem> cartItems = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : productEntities.entrySet()) {
            int productId = entry.getKey();
            int quantity = entry.getValue();
            ProductEntity productEntity = productRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm"));

            Product product = ProductConverter.toModel(productEntity);
            CartItem cartItem = new CartItem(product, quantity);
            cartItems.add(cartItem);
        }
        return cartItems;
    }
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Map.Entry<Integer, Integer> entry : productEntities.entrySet()) {
            int productId = entry.getKey();
            int quantity = entry.getValue();
            ProductEntity productEntity = productRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm"));

            Product product = ProductConverter.toModel(productEntity);
            double productPrice = product.getPrice();
            totalPrice += productPrice * quantity;
        }
        return totalPrice;
    }

}
