package com.example.ss14_bt_bai1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


public class BlogDTO {
    Long id;
    @NotBlank(message = "name input something!!")
    String name;
    @NotBlank(message = "content input something!!")
    String content;
    @NotBlank(message = "title input something!!")
    String title;
    @Min(value = 1,message = "category shouldn't null, choice something!!!")
    Integer category;

    public BlogDTO() {
    }

    public BlogDTO(@NotBlank(message = "name input something!!") String name, @NotBlank(message = "content input something!!") String content, @NotBlank(message = "title input something!!") String title, @Min(value = 1, message = "category shouldn't null, choice something!!!") Integer category) {
        this.name = name;
        this.content = content;
        this.title = title;
        this.category = category;
    }

    public BlogDTO(Long id, @NotBlank(message = "name input something!!") String name, @NotBlank(message = "content input something!!") String content, @NotBlank(message = "title input something!!") String title, @Min(value = 1, message = "category shouldn't null, choice something!!!") Integer category) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.title = title;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }
}
