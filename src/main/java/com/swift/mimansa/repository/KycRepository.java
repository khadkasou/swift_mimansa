package com.swift.mimansa.repository;

import com.swift.mimansa.entity.Kyc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KycRepository extends JpaRepository<Kyc,Long> {


}
