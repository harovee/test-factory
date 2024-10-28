package com.example.demo.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UpdateProductRequest {
    private String productName;

    private Long brandId;

    private Long subCategoryId;

    private Float originPrice;
    private Float sellPrice;

    private String color;

    private Long quantity;

    private Long statusId;
}
