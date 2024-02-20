package com.swift.mimansa.controller;

import com.swift.mimansa.dto.KycDto;
import com.swift.mimansa.entity.Kyc;
import com.swift.mimansa.service.KycService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/kyc")
@RequiredArgsConstructor
public class KycController {

    private final KycService kycService;


    @PostMapping("/create")
    public ResponseEntity<Kyc> saveCustomerKyc(@RequestBody KycDto kycDto){
        Kyc kyc= kycService.save(kycDto);
        return new ResponseEntity<>(kyc, HttpStatus.OK);
    }

}
