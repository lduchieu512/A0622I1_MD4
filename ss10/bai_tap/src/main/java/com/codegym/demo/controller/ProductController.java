package com.codegym.demo.controller;


import com.codegym.demo.model.Cart;
import com.codegym.demo.model.Product;
import com.codegym.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop(){
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products",productService.findAll());
        return modelAndView;
    }


    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart,
                            RedirectAttributes redirectAttributes,
                            @RequestParam("action") String action){
        Optional<Product> productOptional = productService.findById(id);
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

    @GetMapping("/decrease/{id}")
    public String decreaseCart(@PathVariable Long id,@ModelAttribute Cart cart,
                               @RequestParam("action") String action){
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()){
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.decreaseProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.decreaseProduct(productOptional.get());
        return "redirect:/shop";
    }
    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action,
                             Model model) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()){
            return "error-404";
        } else {
            model.addAttribute("product", productOptional.get());
            return "/detail";
        }
    }

    @PostMapping("/success")
    public String successOrder(){
        return "success";
    }





}























