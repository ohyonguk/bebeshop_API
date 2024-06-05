package com.bebe.spring.v2api;

import com.bebe.spring.v2domain.ApiResponse;
import com.bebe.spring.v2domain.CategoryV2;
import com.bebe.spring.v2service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryApiController {
    private final CategoryService categoryService;

    @PostMapping("/create")
    public ApiResponse createCategory(@RequestBody CategoryV2 categoryV2){
        ApiResponse apiResponse = ApiResponse.builder().success(true).build();
        try {
            categoryService.createCategory(categoryV2);
        }catch (Exception e){
            apiResponse = ApiResponse.builder().success(false).message(e.getLocalizedMessage()).build();
        }


        return apiResponse;
    }


}
