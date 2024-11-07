package com.example.demo.model.response.impl;

import com.example.demo.entity.SubCategory;
import com.example.demo.model.response.SubcategoryResponse;

public class CommonSubCateResponse implements SubcategoryResponse {
    private final SubCategory subCategory;

    public CommonSubCateResponse(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    @Override
    public Long getId() {
        return this.getId();
    }

    @Override
    public String getSubCateName() {
        return this.getSubCateName();
    }
}
