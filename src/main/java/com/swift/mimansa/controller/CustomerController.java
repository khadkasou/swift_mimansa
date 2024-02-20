package com.swift.mimansa.controller;


import com.swift.mimansa.dto.CustomerDto;
import com.swift.mimansa.entity.Customer;
import com.swift.mimansa.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {


    private final CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDto customerDto){
        Customer customer = customerService.save(customerDto);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id") Long id){
        Customer customer = customerService.findById(id);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }



    @GetMapping("/list")
    public ResponseEntity<List<Customer>> showAllCustomer(){
        List<Customer> clist = customerService.getAllCustomer();
        return new ResponseEntity<>(clist,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable("id") Long id,
                                                    @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerDto,id);
        return new ResponseEntity<>("Customer updated successfully", HttpStatus.OK);
    }

}
