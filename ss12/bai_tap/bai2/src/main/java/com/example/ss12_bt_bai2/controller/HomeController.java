package com.example.ss12_bt_bai2.controller;

import com.example.ss12_bt_bai2.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private ISmartphoneService smartphoneService;
    @GetMapping("/")
    public String ShowIndex(){
        return "/index";
    }
    @GetMapping("/smartphones/list")
    public ModelAndView getAllSmartphonePage(Model model){
        ModelAndView modelAndView = new ModelAndView("/phones/list");
        modelAndView.addObject("smartphones", smartphoneService.findAll());
        return modelAndView;

    }
}
