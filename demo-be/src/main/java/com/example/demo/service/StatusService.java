package com.example.demo.service;

import org.springframework.http.ResponseEntity;

public interface StatusService {
    ResponseEntity<?> getStatusList();
}
