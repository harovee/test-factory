package com.example.demo.service.impl;

import com.example.demo.entity.SubCategory;
import com.example.demo.model.response.SubcategoryResponse;
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
        List<SubcategoryResponse> subCateResponseList = new ArrayList<>();
        for (SubCategory sc : listSubcate) {
            SubcategoryResponse scResponse = new SubcategoryResponse() {
                @Override
                public Long getId() {
                    return sc.getId();
                }

                @Override
                public String getSubCateName() {
                    return sc.getSubCateName();
                }

            };
            subCateResponseList.add(scResponse);
        }

        return new ResponseEntity<>(subCateRepository.findAll(), HttpStatus.OK);
    }


}
