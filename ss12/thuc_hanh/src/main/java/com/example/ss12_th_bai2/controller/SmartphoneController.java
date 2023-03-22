package com.example.ss12_th_bai2.controller;

import com.example.ss12_th_bai2.model.Smartphone;
import com.example.ss12_th_bai2.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService service;

    @PostMapping
    public ResponseEntity<Smartphone> createSmathphone(@RequestBody Smartphone smartphone){
        return new ResponseEntity<>(service.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage(Model model){
        ModelAndView modelAndView = new ModelAndView("/phones/list");
        modelAndView.addObject("smartphones", service.findAll());
        return modelAndView;

    }














}
