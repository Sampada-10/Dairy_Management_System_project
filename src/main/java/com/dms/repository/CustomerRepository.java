package com.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dms.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
