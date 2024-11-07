package com.example.demo.model.response.impl;

import com.example.demo.entity.Status;
import com.example.demo.model.response.StatusResponse;

public class CommonStatusReponse implements StatusResponse {
    private final Status status;

    public CommonStatusReponse(Status status) {
        this.status = status;
    }

    @Override
    public Long getId() {
        return status.getId();
    }

    @Override
    public String getStatusName() {
        return status.getStatusName();
    }
}
