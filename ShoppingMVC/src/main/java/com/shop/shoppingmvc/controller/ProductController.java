package com.shop.shoppingmvc.controller;

import com.shop.shoppingmvc.entity.CartEntity;
import com.shop.shoppingmvc.entity.ProductEntity;
import com.shop.shoppingmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class ProductController {
    private final ProductService productService;
    private final CartEntity cartEntity;

    public ProductController(ProductService productService, CartEntity cartEntity) {
        this.productService = productService;
        this.cartEntity = cartEntity;
    }
    @GetMapping
    public String listProduct(Model model){
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("product", new ProductEntity());
        return "home";
    }
    @PostMapping
    public String add(@ModelAttribute ProductEntity product) {
        cartEntity.add(product);
        return "redirect:/home";
    }
}
