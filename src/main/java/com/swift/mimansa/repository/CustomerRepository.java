package com.swift.mimansa.repository;

import com.swift.mimansa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Customer findByEmail(String email);

//    Customer findByCustomer_id(Long id);


}
