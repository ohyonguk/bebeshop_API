package com.bebe.spring.v2domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "category")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryV2 {
    @Id
    private String categoryNo;

    private String categoryName;

    private Integer depth;

//    @OneToMany(mappedBy = "categoryV2")
//    private List<CategoryV2> category;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private CategoryV2 categoryV2;

//    public void childCategory(CategoryV2 child){
//        this.category.add(child);
//        child.setCategoryV2(this);
//    }

    public CategoryV2(String categoryNo, String categoryName, Integer depth) {
        this.categoryNo = categoryNo;
        this.categoryName = categoryName;
        this.depth = depth;
    }
}
