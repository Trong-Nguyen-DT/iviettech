package com.shop.shoppingmvc.controller;

import com.shop.shoppingmvc.entity.CartEntity;
import com.shop.shoppingmvc.entity.OrderEntity;
import com.shop.shoppingmvc.service.OrderDetailService;
import com.shop.shoppingmvc.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartController {

    @Autowired
    private CartEntity cartEntity;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private OrderService orderService;

    @GetMapping("cart")
    public String showProductByCart(Model model) {
        model.addAttribute("cartItems", cartEntity.getAllCartItems());
        return "cart";
    }
    @PostMapping("/add-to-cart")
    public String addItemToCart(@RequestParam int id, Model model) {
        cartEntity.addItem(id);
        model.addAttribute("message", "Add success");
        return "redirect:/home";
    }
    @PostMapping("/remove-product")
    public String removeItem(@RequestParam int id, Model model) {
        cartEntity.removeItem(id);
        model.addAttribute("message", "Add success");
        return "redirect:/cart";
    }
    @GetMapping("/pay")
    public String payCart(Model model){
        model.addAttribute("cartItems", cartEntity.getAllCartItems());
        model.addAttribute("cartTotal", cartEntity.getTotalPrice());
        return "pay";
    }
    @PostMapping("checkout")
    @Transactional
    public String checkOut(@RequestParam("name") String name, @RequestParam("address") String address) {
        OrderEntity orderEntity = orderService.addOrder(name, address);
        orderDetailService.addOrderDetail(orderEntity, cartEntity.getAllCartItems());
        return "thankyou";
    }
}
