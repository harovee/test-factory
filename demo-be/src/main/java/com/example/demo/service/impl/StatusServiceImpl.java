package com.example.demo.service.impl;

import com.example.demo.entity.Status;
import com.example.demo.model.response.StatusResponse;
import com.example.demo.model.response.impl.CommonStatusReponse;
import com.example.demo.repository.StatusRepository;
import com.example.demo.service.StatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusServiceImpl implements StatusService {
    private final StatusRepository statusRepository;

    @Override
    public ResponseEntity<?> getStatusList() {
        List<Status> listStatus = statusRepository.findAll();
        if (listStatus.isEmpty()) {
            return new ResponseEntity<>("Danh sach rong", HttpStatus.BAD_REQUEST);
        }
        List<CommonStatusReponse> statusResponseList = new ArrayList<>();
        for (Status status : listStatus) {
            CommonStatusReponse statusResponse = new CommonStatusReponse(status);
            statusResponseList.add(statusResponse);
        }
        return new ResponseEntity<>(statusRepository.findAll(), HttpStatus.OK);
    }
}
