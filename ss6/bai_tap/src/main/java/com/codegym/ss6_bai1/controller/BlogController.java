package com.codegym.ss6_bai1.controller;

import com.codegym.ss6_bai1.model.Blog;
import com.codegym.ss6_bai1.service.IBlogService;
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
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/list")
    public String doList(Model model){
        List<Blog> blogList = iBlogService.findAll();
        model.addAttribute("blogList",blogList);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "create";
    }

    @PostMapping("create")
    public String doCreate(@ModelAttribute("blog")Blog blog,
                           Model model, RedirectAttributes redirectAttributes){
        iBlogService.create(blog);
        redirectAttributes.addFlashAttribute("msg","Thêm mới thành công");
        return"redirect:list";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable("id")Integer id, Model model){
       Blog blog= iBlogService.findById(id);
        model.addAttribute("blog",blog);
        return "edit";
    }

    @PostMapping("edit")
    public String doEdit(@ModelAttribute("blog") Blog blog,Model model,RedirectAttributes redirectAttributes){
        iBlogService.create(blog);
        redirectAttributes.addFlashAttribute("msg","Edit thành công");
        return"redirect:list";
    }



}
