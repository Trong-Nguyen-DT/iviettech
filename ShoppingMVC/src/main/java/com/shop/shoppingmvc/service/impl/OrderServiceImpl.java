package com.shop.shoppingmvc.service.impl;

import com.shop.shoppingmvc.entity.OrderEntity;
import com.shop.shoppingmvc.repository.OrderRepository;
import com.shop.shoppingmvc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public OrderEntity addOrder(String name, String address) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderDateTime(LocalDateTime.now());
        orderEntity.setCustomerName(name);
        orderEntity.setCustomerAddress(address);
        return orderRepository.save(orderEntity);
    }
}
