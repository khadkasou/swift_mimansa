package com.swift.mimansa.service;

import com.swift.mimansa.dto.KycDto;
import com.swift.mimansa.entity.Kyc;

import java.util.List;

public interface KycService {

    Kyc save(KycDto kycDto);
    List<Kyc> listAllCustomer();
    Kyc findById(Long id);
    Kyc updateKyc(KycDto kycDto, Long id);



}
