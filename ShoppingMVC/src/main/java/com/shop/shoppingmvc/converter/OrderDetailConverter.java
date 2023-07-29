package com.shop.shoppingmvc.converter;

import com.shop.shoppingmvc.domain.OrderDetail;
import com.shop.shoppingmvc.entity.OrderDetailEntity;

public class OrderDetailConverter {
    public static OrderDetail toModel(OrderDetailEntity orderDetailEntity){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProduct(ProductConverter.toModel(orderDetailEntity.getProductEntity()));
        orderDetail.setQuantity(orderDetailEntity.getQuantity());
        return orderDetail;
    }
}
