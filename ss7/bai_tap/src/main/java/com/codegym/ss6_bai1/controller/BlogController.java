package com.codegym.ss6_bai1.controller;

import com.codegym.ss6_bai1.model.Blog;
import com.codegym.ss6_bai1.model.Category;
import com.codegym.ss6_bai1.service.IBlogService;
import com.codegym.ss6_bai1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public String doList(Model model,
                          @RequestParam(required = false, defaultValue = "") String searchName,
                         @PageableDefault(sort = "name",direction = Sort.Direction.DESC)
                                     Pageable pageable){
        Page<Blog> blogList =iBlogService.search(searchName,pageable);
        List<Category> categoryList = categoryService.findAll();
//        List<Blog> blogList = iBlogService.findAll();
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("blogList",blogList);
        model.addAttribute("searchName",searchName);
        return "list";
    }

    @GetMapping("/blog/create")
    public String showCreate(Model model){
        List<Category>categoryList = categoryService.findAll();
        Blog blog = new Blog();
        blog.setCategory(new Category());
        model.addAttribute("blog",blog);
        model.addAttribute("categoryList",categoryList);
        return "blog/create";
    }

    @PostMapping("/blog/create")
    public String doCreate(@ModelAttribute("blog")Blog blog,
                           Model model, RedirectAttributes redirectAttributes){
        iBlogService.create(blog);
        redirectAttributes.addFlashAttribute("msg","Thêm Blog mới thành công");
        return"redirect:/list";
    }

    @GetMapping("/blog/edit/{id}")
    public String showEdit(@PathVariable("id")Integer id, Model model){
       Blog blog= iBlogService.findById(id);
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("blog",blog);
        return "blog/edit";
    }

    @PostMapping("/blog/edit")
    public String doEdit(@ModelAttribute("blog") Blog blog,Model model,RedirectAttributes redirectAttributes){
        iBlogService.create(blog);
        redirectAttributes.addFlashAttribute("msg","Edit Blog thành công");
        return"redirect:/list";
    }

    @GetMapping("/blog/delete/{id}")
    public String doDelete(@PathVariable("id")Integer id, RedirectAttributes redirectAttributes){
        iBlogService.delete(id);
        redirectAttributes.addFlashAttribute("msg","Xoá Blog thành công");
        return"redirect:/list";

    }



}
