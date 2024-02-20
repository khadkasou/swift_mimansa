package com.swift.mimansa.dto;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private String firstName;
    private String middleName;
    private String lastName;
    private Date dateOfBirth;
    private String address;
    private String phoneNumber;
    private String email;
    private String gender;



}
