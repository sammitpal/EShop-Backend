package com.electronics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electronics.model.Product;
import com.electronics.repository.ProductRepository;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	@PostMapping("/save")
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@GetMapping("/fetch")
	public Iterable<Product> fetchAll() {
		return productRepository.findAll();
	}
	
	@GetMapping("/fetch/{id}")
	public Product fetchById(@PathVariable int id) {
		return productRepository.findById(id).orElse(null);
	}
	
}
