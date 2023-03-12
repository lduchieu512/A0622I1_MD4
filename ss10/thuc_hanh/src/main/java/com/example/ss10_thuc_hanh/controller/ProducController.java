package com.example.ss10_thuc_hanh.controller;

import com.example.ss10_thuc_hanh.models.Cart;
import com.example.ss10_thuc_hanh.models.Product;
import com.example.ss10_thuc_hanh.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProducController {

    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shop")
    public String showShop(Model model){
        model.addAttribute("products",iProductService.findAll());
        return "shop";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,@ModelAttribute Cart cart,
                            RedirectAttributes redirectAttributes,
                            @RequestParam("action") String action){
        Optional<Product> productOptional = iProductService.findById(id);
        if (!productOptional.isPresent()){
            return "/error.404";
        }
        if (action.equals("show")){
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        redirectAttributes.addFlashAttribute("msg","them moi thanh cong");
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }


}
