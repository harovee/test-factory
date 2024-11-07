package com.example.demo.service.impl;

import com.example.demo.entity.SubCategory;
import com.example.demo.model.response.SubcategoryResponse;
import com.example.demo.model.response.impl.CommonBrandResponse;
import com.example.demo.model.response.impl.CommonSubCateResponse;
import com.example.demo.repository.SubCateRepository;
import com.example.demo.service.SubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubcategoryServiceImpl implements SubCategoryService {
    private final SubCateRepository subCateRepository;

    @Override
    public ResponseEntity<?> getSubcategories() {
        List<SubCategory> listSubcate = subCateRepository.findAll();
        if (listSubcate.isEmpty()) {
            return new ResponseEntity<>("Danh sach rong", HttpStatus.BAD_REQUEST);
        }
        List<CommonSubCateResponse> subCateResponseList = new ArrayList<>();
        for (SubCategory sc : listSubcate) {
            CommonSubCateResponse scResponse = new CommonSubCateResponse(sc);
            subCateResponseList.add(scResponse);
        }

        return new ResponseEntity<>(subCateRepository.findAll(), HttpStatus.OK);
    }


}
