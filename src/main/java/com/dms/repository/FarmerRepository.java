package com.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dms.entities.Farmer;

public interface FarmerRepository extends JpaRepository<Farmer, Integer>{

}
