package com.platform.demo.controller;

import com.platform.demo.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProvinceController {

    private final ServiceLayer serviceLayer;

    @Autowired
    public ProvinceController(ServiceLayer serviceLayer){
        this.serviceLayer = serviceLayer;
    }

    @GetMapping("/provinces")
    public ResponseEntity<?> getProvinces(){
        return ResponseEntity.ok(serviceLayer.consumeAPI());
    }
}
