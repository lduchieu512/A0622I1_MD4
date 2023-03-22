package com.example.ss12_bt_bai2.controller;

import com.example.ss12_bt_bai2.model.Smartphone;
import com.example.ss12_bt_bai2.service.ISmartphoneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService service;

    @PostMapping
    public ResponseEntity<Smartphone> createSmathphone(@RequestBody Smartphone smartphone){
        return new ResponseEntity<>(service.save(smartphone), HttpStatus.CREATED);
    }


    @GetMapping()
    public ResponseEntity<Iterable<Smartphone>> allPhones(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Smartphone> getById(@PathVariable long id){
        Optional<Smartphone> smartphoneOptional =service.findById(id);
        if (!smartphoneOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(smartphoneOptional.get(),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartPhone(@PathVariable Long id){
        Optional<Smartphone> smartphoneOptional = service.findById(id);
        if (!smartphoneOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(),HttpStatus.NO_CONTENT);
    }

    @PostMapping("edit/{id}")
    public ResponseEntity<Smartphone> editSmartPhone(@PathVariable Long id){
        Optional<Smartphone> smartphoneOptional = service.findById(id);
        if (!smartphoneOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.save(smartphoneOptional.get());
        return new ResponseEntity<>(smartphoneOptional.get(),HttpStatus.NO_CONTENT);
    }


















}
