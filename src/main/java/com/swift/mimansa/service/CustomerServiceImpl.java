package com.swift.mimansa.service;

import com.swift.mimansa.dto.CustomerDto;
import com.swift.mimansa.entity.Customer;
import com.swift.mimansa.exceptions.GlobalExceptions;
import com.swift.mimansa.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{


    private final CustomerRepository customerRepository;


    @Override
    public Customer save(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setMiddleName(customerDto.getMiddleName());
        customer.setLastName(customerDto.getLastName());
        customer.setAddress(customerDto.getAddress());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setGender(customerDto.getGender());
        Customer cusEmail = customerRepository.findByEmail(customerDto.getEmail());
        if (!Objects.isNull(cusEmail)){
            throw new GlobalExceptions("Customer with email "+customerDto.getEmail()+" already exists.");
        }
        customer.setEmail(customerDto.getEmail());
        customer.setDateOfBirth(customerDto.getDateOfBirth());
        return customerRepository.save(customer);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);

    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(CustomerDto customerDto, Long id) {

        Optional<Customer> customerId = customerRepository.findById(id);

        if (customerId.isEmpty()) {
            throw new GlobalExceptions("Customer with id:" + id + " not found.");
        }
        Customer upCustomer = customerId.get();
        upCustomer.setFirstName(customerDto.getFirstName());
        upCustomer.setMiddleName(customerDto.getMiddleName());
        upCustomer.setLastName(customerDto.getLastName());
        upCustomer.setAddress(customerDto.getAddress());
        upCustomer.setPhoneNumber(customerDto.getPhoneNumber());
        upCustomer.setEmail(customerDto.getEmail());
        upCustomer.setGender(customerDto.getGender());
        upCustomer.setDateOfBirth(customerDto.getDateOfBirth());

        return customerRepository.save(upCustomer);
    }
}
