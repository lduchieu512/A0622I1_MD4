package com.example.ss14_bt_bai1.model;


import java.util.EnumSet;


public enum  Category {
    NULL(0),
    REVIEW(1),
    REACTION(2),
    TUTORIAL(3);
    private Integer id;

    Category(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public static Category getCategoryById(Integer id){
        return EnumSet.allOf(Category.class).stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
    }
}
