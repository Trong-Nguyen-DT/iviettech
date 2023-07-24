package com.shop.shoppingmvc.controller;

import com.shop.shoppingmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class ProductController {
    @Autowired
    private ProductService producrtService;
    @GetMapping
    public String listProduct(Model model){
        model.addAttribute("products", producrtService.getAllProducts());
        return "home";
    }
}
