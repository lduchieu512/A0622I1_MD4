package com.example.ss14_bt_bai1.controller;

import com.example.ss14_bt_bai1.model.Category;
import com.example.ss14_bt_bai1.service.IBlogService;
import com.example.ss14_bt_bai1.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    List<Category> categoryList = Arrays.asList(Category.values());

    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/")
    public String display(Model model){
         model.addAttribute("list",iBlogService.finAll());
         model.addAttribute("categoryList",categoryList);
        return "home";
    }

    @GetMapping("/login")
    public String showLogin(){
        return "login";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal){
        // sau khi login thành công sẽ có principal
        String username = principal.getName();
        System.out.println("Username: "+username);

        User login = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(login);
        model.addAttribute("userInfo",userInfo);
        return "login";
    }

}
