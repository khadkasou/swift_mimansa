package com.swift.mimansa.service;

import com.swift.mimansa.dto.CustomerDto;
import com.swift.mimansa.entity.Customer;

import java.util.List;

public interface CustomerService {

 Customer save(CustomerDto customerDto);
 Customer findById(Long id);
 Customer findByEmail(String email);
 List<Customer> getAllCustomer();

 Customer updateCustomer(CustomerDto customerDto, Long id);


}
