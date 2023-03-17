package com.example.ss12_th_bai2.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String ShowIndex(){
        return "/index";
    }
}
