package com.example.demo.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String productName;

    private String color;

    private Long quantity;

    private Float sellPrice;

    private Float originPrice;

    private Long subCategoryId;

    private Long statusId;

    private Long brandId;
}
