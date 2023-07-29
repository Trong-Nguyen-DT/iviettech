package com.shop.shoppingmvc.service.impl;

import com.shop.shoppingmvc.converter.OrderDetailConverter;
import com.shop.shoppingmvc.converter.ProductConverter;
import com.shop.shoppingmvc.domain.OrderDetail;
import com.shop.shoppingmvc.entity.CartEntity;
import com.shop.shoppingmvc.entity.OrderDetailEntity;
import com.shop.shoppingmvc.entity.OrderEntity;
import com.shop.shoppingmvc.entity.ProductEntity;
import com.shop.shoppingmvc.repository.OrderDetailRepository;
import com.shop.shoppingmvc.repository.ProductRepository;
import com.shop.shoppingmvc.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public void addOrderDetail(OrderEntity orderEntity, List<OrderDetail> orderDetails) {
        for (OrderDetail orderDetail : orderDetails) {
            OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
            orderDetailEntity.setOrderEntity(orderEntity);
            ProductEntity productEntity = productRepository.findById(orderDetail.getProduct().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy sản phẩm với id: " + orderDetail.getProduct().getId()));
            orderDetailEntity.setProductEntity(productEntity);
            orderDetailEntity.setQuantity(orderDetail.getQuantity());
            orderDetailRepository.save(orderDetailEntity);
        }
    }
}
