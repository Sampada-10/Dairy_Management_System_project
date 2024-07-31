package com.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dms.entities.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer>{

}
