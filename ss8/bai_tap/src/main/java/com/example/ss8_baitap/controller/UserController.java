package com.example.ss8_baitap.controller;

import com.example.ss8_baitap.model.User;
import com.example.ss8_baitap.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/list")
    public  String doList(Model model){
        List<User> userList = iUserService.findAll();
        model.addAttribute("userList",userList);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model  model){
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/create")
    public String doCreate(@Valid @ModelAttribute("user")User user,
                           BindingResult bindingResult,Model model
                           ,RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            model.addAttribute("user",user);
            return "create";
        }
        iUserService.create(user);
        redirectAttributes.addFlashAttribute("mess", "Create new successfully");
        return "redirect:/list";
    }










}
