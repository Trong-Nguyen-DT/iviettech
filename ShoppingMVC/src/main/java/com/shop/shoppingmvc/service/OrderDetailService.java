package com.shop.shoppingmvc.service;

import com.shop.shoppingmvc.domain.OrderDetail;
import com.shop.shoppingmvc.entity.OrderEntity;

import java.util.List;

public interface OrderDetailService {
    void addOrderDetail(OrderEntity orderEntity, List<OrderDetail> cartItems);
}
