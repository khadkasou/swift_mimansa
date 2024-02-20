package com.swift.mimansa.dto;

import com.swift.mimansa.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KycDto {
    private String grandFatherName;
    private String fatherName;
    private String motherName;
    private String occupation;
    private String nationality;
    private String temporaryAddress;
    private String permanentAddress;
    private Long customerId;
}
