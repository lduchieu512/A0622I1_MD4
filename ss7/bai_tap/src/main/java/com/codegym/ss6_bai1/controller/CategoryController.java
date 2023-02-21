package com.codegym.ss6_bai1.controller;

import com.codegym.ss6_bai1.model.Category;
import com.codegym.ss6_bai1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class CategoryController {
    @Autowired
    private ICategoryService service;

    @GetMapping("/category/create")
    public String showCreate(Model model){
        model.addAttribute("category",new Category());
        return "category/create";
    }

    @PostMapping("/category/create")
    public String doCreate(@ModelAttribute("category")Category category, Model model,
                           RedirectAttributes redirectAttributes){
        service.create(category);
        redirectAttributes.addFlashAttribute("msg","Thêm Category mới thành công");
        return"redirect:/list";
    }

    @GetMapping("/category/edit/{id}")
    public String showEdit(@PathVariable("id")Integer id, Model model){
        Category category=service.findById(id);
        model.addAttribute("category",category);
        return "/category/edit";

    }

    @PostMapping("/category/edit")
    public String doEdit(@ModelAttribute("category")Category category,RedirectAttributes redirectAttributes){
        service.create(category);
        redirectAttributes.addFlashAttribute("msg","Edit Category thành công");
        return"redirect:/list";
    }

    @GetMapping("/category/delete/{id}")
    public String doDelete(@PathVariable("id")Integer id,RedirectAttributes redirectAttributes){
        service.delete(id);
        redirectAttributes.addFlashAttribute("msg","Xoá Category thành công");
        return"redirect:/list";
    }




}
