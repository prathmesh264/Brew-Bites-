package com.example.pro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pro.Entity.Order;
import com.example.pro.Entity.orderStatusEnum;
import com.example.pro.Service.orderService;

@RestController
public class OrderController {

	@Autowired
	private orderService orService;

	@PutMapping("/orders/{id}/{status}")
	public String UpdateStatus(@PathVariable("id") int id, @PathVariable("status") orderStatusEnum status) {

		orService.updateStatus(id, status);

		return "Update status to: " + status + " of order with id: " + id;

	}

	@GetMapping("/orders/name/{name}")
	public List<Order> FindByName(@PathVariable("name") String name) {
		return orService.getByName(name);
	}

	@PostMapping("/orders")
	public Order addOrder(@RequestBody Order or) {
		return orService.save(or);

	}

	@PutMapping("/orders")
	public Order UpdateOrder(@RequestBody Order or) {
		return orService.save(or);
	}

	@GetMapping("/orders")
	public List<Order> FindAll() {

		return orService.getAll();
	}
	
	
	@GetMapping("/orders/{id}")
	public Order FindById(@PathVariable("id") int id) {

		return orService.getById(id);
	}

	@DeleteMapping("/orders/{id}")
	public String deleteById(@PathVariable("id") int id) {
		orService.deleteById(id);
		return "Deleted successfully " + id;

	}

}
