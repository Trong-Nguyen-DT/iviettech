package com.shop.shoppingmvc.controller;

import com.shop.shoppingmvc.entity.CartEntity;
import com.shop.shoppingmvc.entity.OrderEntity;
import com.shop.shoppingmvc.service.OrderDetailService;
import com.shop.shoppingmvc.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("cart")
public class CartController {

    @Autowired
    private CartEntity cartEntity;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping
    public String showProductByCart(Model model) {
        model.addAttribute("orderdetails", cartEntity.getAllCartItems());
        return "cart";
    }
    @PostMapping("/remove")
    public String removeItem(@RequestParam Integer id, Model model) {
        System.out.println(id);
        cartEntity.remove(id);
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
    public String checkOut(@RequestParam("name") String name, @RequestParam("address") String address, Model model) {
        OrderEntity orderEntity = orderService.addOrder(name, address);
        orderDetailService.addOrderDetail(orderEntity, cartEntity.getAllCartItems());
        model.addAttribute("name", name);
        model.addAttribute("address", address);
        model.addAttribute("products", cartEntity.getAllCartItems());
        model.addAttribute("cartTotal", cartEntity.getTotalPrice());
        return "thankyou";
    }
    @GetMapping("emty")
    public String empty() {
        cartEntity.emptyCart();
        return "redirect:/cart";
    }
    @GetMapping("back")
    public String back() {
        return "redirect:/home";
    }
}
