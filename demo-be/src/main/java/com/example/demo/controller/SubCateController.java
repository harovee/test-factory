package com.example.demo.controller;

import com.example.demo.service.SubCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/sub-cate")
public class SubCateController {
    private final SubCategoryService scService;

    public SubCateController(SubCategoryService scService) {
        this.scService = scService;
    }

    @GetMapping
    public ResponseEntity<?> getAllSubCategory(){
        return scService.getSubcategories();
    }
}
