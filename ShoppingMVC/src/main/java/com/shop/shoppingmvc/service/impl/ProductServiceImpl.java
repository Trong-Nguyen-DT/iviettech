package com.shop.shoppingmvc.service.impl;

import com.shop.shoppingmvc.converter.ProductConverter;
import com.shop.shoppingmvc.domain.Product;
import com.shop.shoppingmvc.entity.ProductEntity;
import com.shop.shoppingmvc.repository.ProductRepository;
import com.shop.shoppingmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll().stream().map(ProductConverter::toModel).collect(Collectors.toList());
    }
}
