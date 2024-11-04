package com.example.demo.service;

import com.example.demo.entity.Brand;
import org.springframework.http.ResponseEntity;

public interface BrandService {
    ResponseEntity<?> getBrands();
}
