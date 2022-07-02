package com.electronics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electronics.model.Order;
import com.electronics.model.Product;
import com.electronics.repository.OrderRepository;
import com.electronics.repository.ProductRepository;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	ProductRepository productRepository;

	@PostMapping("/buy/{id}")
	public Order createOrder(@PathVariable int id, @RequestBody Order orderBody) {

		Product product = productRepository.findById(id).orElse(null);
		Order order = new Order();
		if (product != null) {
			if (product.getQty() - orderBody.getOrderqty() != 0) {

				product.setQty(product.getQty() - orderBody.getOrderqty());
				productRepository.save(product);

				order.setOrderqty(orderBody.getOrderqty());
				order.setTotalprice(orderBody.getOrderqty() * product.getDealprice());
				order.setProduct(product);
			}

		}
		return orderRepository.save(order);
	}
	
	@GetMapping("/fetch")
	public Iterable<Order> fetchAll() {
		return orderRepository.findAll();
	}
}
