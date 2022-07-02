package com.electronics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electronics.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
