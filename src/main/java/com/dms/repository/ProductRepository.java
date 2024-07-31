package com.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dms.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
