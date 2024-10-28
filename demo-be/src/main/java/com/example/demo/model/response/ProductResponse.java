package com.example.demo.model.response;

import java.util.List;

public interface ProductResponse {
    Long getId();
    String getProductName();
    List<String> getBrandName();

    String getSubCategory();

    Float getOriginPrice();

    String getStatus();

}
