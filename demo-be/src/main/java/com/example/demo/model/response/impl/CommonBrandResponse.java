package com.example.demo.model.response.impl;

import com.example.demo.entity.Brand;
import com.example.demo.model.response.BrandResponse;

public class CommonBrandResponse implements BrandResponse {
    private final Brand brand;

    public CommonBrandResponse(Brand brand) {
        this.brand = brand;
    }

    @Override
    public Long getId() {
        return this.getId();
    }

    @Override
    public String getBrandName() {
        return this.getBrandName();
    }
}
