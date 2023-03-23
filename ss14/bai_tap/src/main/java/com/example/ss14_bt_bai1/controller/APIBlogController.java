package com.example.ss14_bt_bai1.controller;

import com.example.ss14_bt_bai1.dto.BlogDTO;
import com.example.ss14_bt_bai1.model.Blog;
import com.example.ss14_bt_bai1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin("/*")
public class APIBlogController {

    @Autowired
    private  IBlogService iBlogService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> getList(){
        return new ResponseEntity<>(iBlogService.finAll(), HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<Blog> createData(@Valid @RequestBody BlogDTO blogDTO){
        return new ResponseEntity<>(iBlogService.save(new Blog(blogDTO)),HttpStatus.CREATED);
    }

    @PatchMapping("/edit")
    public ResponseEntity<Blog> editData(@Valid @RequestBody BlogDTO blogDTO){
        Blog  blog = new Blog(blogDTO);
        blog.setId(blogDTO.getId());
        return new ResponseEntity<>(iBlogService.save(blog),HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<Blog>> deleteData(@PathVariable Long id){
        iBlogService.remove(id);
        return new ResponseEntity<>(iBlogService.finAll(),HttpStatus.NO_CONTENT);
    }





















}
