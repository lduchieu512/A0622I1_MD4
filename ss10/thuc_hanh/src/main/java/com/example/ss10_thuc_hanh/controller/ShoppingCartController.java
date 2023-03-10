package com.example.ss10_thuc_hanh.controller;

import com.example.ss10_thuc_hanh.models.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class ShoppingCartController {

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }


    @GetMapping("/shopping-cart")
    public String showCart(@SessionAttribute("cart") Cart cart, Model model){
        model.addAttribute("cart",cart);
        return "cart";
    }


















}
