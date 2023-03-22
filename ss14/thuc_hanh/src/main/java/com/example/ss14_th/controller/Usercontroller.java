package com.example.ss14_th.controller;

import com.example.ss14_th.security.SecurityConfig;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class Usercontroller {

    @GetMapping("/")
    public ModelAndView index(){
        return new ModelAndView("/index");
    }

    @GetMapping("/user")
    public ModelAndView user(Principal principal){
        // Get authenticated user name from Principal
        // Nhận tên người dùng được xác thực từ  Principal
        System.out.println(principal.getName());
        return new ModelAndView("/user");

    }

    @GetMapping("/admin")
    public ModelAndView admin(){
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println(context.getAuthentication().getName());
        return new ModelAndView("/admin");
    }






























}
