package com.example.ss12_th_bai2.controller;

import com.example.ss12_th_bai2.model.Smartphone;
import com.example.ss12_th_bai2.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private ISmartphoneService smartphoneService;

    @GetMapping("/")
    public String showIndex() {
        return "/index";
    }

    @GetMapping("/smartphones/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("/phones/list");
        modelAndView.addObject("smartphones", smartphoneService.findAll());
        return modelAndView;
    }

}
