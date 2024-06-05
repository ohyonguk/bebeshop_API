package com.bebe.spring.v2service;

import com.bebe.spring.v2domain.CategoryV2;
import com.bebe.spring.v2exception.CreateException;
import com.bebe.spring.v2repository.product.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional
    public void createCategory(CategoryV2 categoryV2){
        CategoryV2 category =categoryRepository.findCategory(categoryV2);
        if(category!=null){
            throw new CreateException("존재하는 카테고리 이름 입니다.");
        }
        categoryRepository.createCategory(categoryV2);
    }



}
