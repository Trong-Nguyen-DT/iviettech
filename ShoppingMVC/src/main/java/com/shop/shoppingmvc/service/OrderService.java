package com.shop.shoppingmvc.service;

import com.shop.shoppingmvc.entity.OrderEntity;

public interface OrderService {
    OrderEntity addOrder(String name, String address);
}
