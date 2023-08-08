package com.shop.shoppingmvc.entity;

import com.shop.shoppingmvc.converter.OrderDetailConverter;
import com.shop.shoppingmvc.domain.OrderDetail;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartEntity implements Serializable {
    private OrderEntity orderEntity = new OrderEntity();
    public void add(ProductEntity productEntity) {
        Optional<OrderDetailEntity> existingDetail = orderEntity.getOrderDetails().stream()
                .filter(item -> Objects.equals(item.getProductEntity().getId(), productEntity.getId()))
                .findFirst();

        if (existingDetail.isPresent()) {
            existingDetail.get().setQuantity(existingDetail.get().getQuantity() + 1);
        } else {
            OrderDetailEntity detail = new OrderDetailEntity();
            detail.setProductEntity(productEntity);
            detail.setQuantity(1);
            orderEntity.getOrderDetails().add(detail);
        }
    }


    public void remove(Integer id) {
        OrderDetailEntity detail = Optional.of(orderEntity.getOrderDetails())
                .orElse(new ArrayList<>())
                .stream()
                .filter(item -> Objects.equals(item.getProductEntity().getId(), id))
                .findFirst()
                .orElse(new OrderDetailEntity());

        orderEntity.getOrderDetails().remove(detail);
    }
    public int count(ProductEntity productEntity) {
        long existingCount = orderEntity.getOrderDetails().stream()
                .filter(item -> Objects.equals(item.getProductEntity().getId(), productEntity.getId()))
                .count();
        return (int) existingCount + 1;
    }
    public void emptyCart() {
        orderEntity.setOrderDetails(List.of());
    }

    public List<OrderDetail> getAllCartItems() {
        return orderEntity.getOrderDetails().stream().map(OrderDetailConverter::toModel).collect(Collectors.toList());
    }
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (OrderDetailEntity detail : orderEntity.getOrderDetails()) {
            ProductEntity product = detail.getProductEntity();
            int quantity = detail.getQuantity();
            double price = product.getPrice();
            totalPrice += price * quantity;
        }
        return totalPrice;
    }

}
