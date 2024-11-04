package com.example.demo.service.impl;

import com.example.demo.entity.Brand;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductBrand;
import com.example.demo.model.response.BrandResponse;
import com.example.demo.model.response.ProductResponse;
import com.example.demo.repository.BrandRepository;
import com.example.demo.service.BrandService;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    @Override
    public ResponseEntity<?> getBrands() {
        List<Brand> listBrand = brandRepository.findAll();
        if (listBrand.isEmpty()) {
            return new ResponseEntity<>("Danh sach rong", HttpStatus.BAD_REQUEST);
        }
        List<BrandResponse> brandResponseList = new ArrayList<>();
        for (Brand brand : listBrand) {
            BrandResponse brandResponse = new BrandResponse() {
                @Override
                public Long getId() {
                    return brand.getId();
                }

                @Override
                public String getBrandName() {
                    return brand.getBrandName();
                }
            };
            brandResponseList.add(brandResponse);
        }

        return new ResponseEntity<>(brandRepository.findAll(), HttpStatus.OK);
    }
}
