package com.electronics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electronics.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
