package com.swift.mimansa.service;

import com.swift.mimansa.dto.KycDto;
import com.swift.mimansa.entity.Customer;
import com.swift.mimansa.entity.Kyc;
import com.swift.mimansa.exceptions.GlobalExceptions;
import com.swift.mimansa.repository.CustomerRepository;
import com.swift.mimansa.repository.KycRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KycServiceImpl implements KycService{

    private final KycRepository kycRepository;
    private final CustomerRepository customerRepository;
    @Override
    public Kyc save(KycDto kycDto) {
       Kyc kyc = new Kyc();
       kyc.setFatherName(kycDto.getFatherName());
       kyc.setGrandFatherName(kycDto.getGrandFatherName());
       kyc.setOccupation(kycDto.getOccupation());
       kyc.setNationality(kycDto.getNationality());
       kyc.setMotherName(kycDto.getMotherName());
       kyc.setPermanentAddress(kycDto.getPermanentAddress());
       kyc.setTemporaryAddress(kycDto.getTemporaryAddress());
       if(kycDto.getCustomerId() == null){
           throw new GlobalExceptions("Customer id must not be null");
       }
        Optional<Customer> customer= customerRepository.findById(kycDto.getCustomerId());
        if(customer.isEmpty()){
            throw new GlobalExceptions("The given id "+kycDto.getCustomerId()+ "is not available");
        }
        kyc.setCustomer(customer.get());
        return kycRepository.save(kyc);

    }

    @Override
    public List<Kyc> listAllCustomer() {
        return null;
    }

    @Override
    public Kyc findById(Long id) {
        return null;
    }

    @Override
    public Kyc updateKyc(KycDto kycDto, Long id) {
        return null;
    }
}
