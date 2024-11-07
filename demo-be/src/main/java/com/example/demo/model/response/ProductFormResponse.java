package com.example.demo.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public interface ProductFormResponse {
    Long getId();

    String getProductName();

     String getColor();

     Long getQuantity();

     Float getSellPrice();

     Float getOriginPrice();

     Long getBrandId();

     Long getSubCategoryId();

     Long getStatusId();
}
