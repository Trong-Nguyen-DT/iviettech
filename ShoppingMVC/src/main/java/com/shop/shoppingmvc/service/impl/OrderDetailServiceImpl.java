package com.shop.shoppingmvc.service.impl;

import com.shop.shoppingmvc.converter.ProductConverter;
import com.shop.shoppingmvc.domain.CartItem;
import com.shop.shoppingmvc.domain.OrderDetail;
import com.shop.shoppingmvc.domain.Product;
import com.shop.shoppingmvc.entity.CartEntity;
import com.shop.shoppingmvc.entity.OrderDetailEntity;
import com.shop.shoppingmvc.entity.OrderEntity;
import com.shop.shoppingmvc.entity.ProductEntity;
import com.shop.shoppingmvc.repository.OrderDetailRepository;
import com.shop.shoppingmvc.repository.OrderRepository;
import com.shop.shoppingmvc.repository.ProductRepository;
import com.shop.shoppingmvc.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ProductRepository productRepository;
    private CartEntity cartEntity;
    @Override
    public void addOrderDetail(OrderEntity orderEntity, List<CartItem> cartItems) {
        for (CartItem cartItem : cartItems) {
            OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
            orderDetailEntity.setOrderEntity(orderEntity);

            ProductEntity productEntity = productRepository.findById(cartItem.getProduct().getId()).orElse(null);
            if (productEntity == null) {
                productEntity = new ProductEntity();
                productEntity.setName(cartItem.getProduct().getName());
                productEntity.setPrice(cartItem.getProduct().getPrice());
                productEntity = productRepository.save(productEntity);
            }

            orderDetailEntity.setProductEntity(productEntity);
            orderDetailEntity.setQuantity(cartItem.getQuantity());

            orderDetailRepository.save(orderDetailEntity);
        }
    }
}
