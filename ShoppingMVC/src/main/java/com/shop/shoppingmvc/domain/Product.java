package com.shop.shoppingmvc.domain;

import com.shop.shoppingmvc.entity.OrderDetailEntity;

import java.util.List;

public class Product {
    private int id;
    private String name;
    private Double price;
    private List<OrderDetailEntity> orderEntities;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<OrderDetailEntity> getOrderEntities() {
        return orderEntities;
    }

    public void setOrderEntities(List<OrderDetailEntity> orderEntities) {
        this.orderEntities = orderEntities;
    }
}
