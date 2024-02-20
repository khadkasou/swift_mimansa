package com.swift.mimansa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "customer_kyc_details")
@AllArgsConstructor
@NoArgsConstructor
public class Kyc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_kyc_id")
    private Long id;
    @Column(name = "grandFather_name")
    @NotBlank(message = "GrandFather name is required")
    private String grandFatherName;
    @Column(name = "father_name")
    @NotBlank(message = "Father name is required")

    private String fatherName;
    @Column(name = "mother_name")
    @NotBlank(message = "Mother name is required")

    private String motherName;
    @Column(name = "occupation")
    private String occupation;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "temporary_address")
    private String temporaryAddress;
    @Column(name = "permanent_address")
    private String permanentAddress;
    @OneToOne
    @JoinColumn(name = "customer_id" ,referencedColumnName = "customer_id")
    private Customer customer;

}