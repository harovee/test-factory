package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.model.request.AddProductRequest;
import com.example.demo.model.request.ProductRequest;
import com.example.demo.model.request.UpdateProductRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<?> getProduct(Pageable pageable);

    ResponseEntity<?> addProduct(AddProductRequest request);

    ResponseEntity<?> updateProduct(Long id, UpdateProductRequest request);

    ResponseEntity<?> deleteProduct(Long id);

    ResponseEntity<?> getProductById(Long id);
}
