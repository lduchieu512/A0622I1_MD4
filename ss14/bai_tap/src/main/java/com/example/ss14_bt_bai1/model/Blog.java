package com.example.ss14_bt_bai1.model;

import com.example.ss14_bt_bai1.dto.BlogDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "blog")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String content;
    private String title;

    @Column(name = "category_id")
    Category category;


    public Blog(BlogDTO blogDTO) {
        this.name = blogDTO.getName();
        this.content = blogDTO.getContent();
        this.title = blogDTO.getTitle();
        this.category = Category.getCategoryById(blogDTO.getCategory());
    }
}
