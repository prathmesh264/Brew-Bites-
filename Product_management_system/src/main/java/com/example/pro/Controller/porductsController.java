package com.example.pro.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pro.Entity.Products;
import com.example.pro.Services.productsService;

@RestController
public class porductsController {
	
	@Autowired
	private productsService proser;
	
	@GetMapping("/products/category/{cat}")
	public List<Products> getProductsByCategory(@PathVariable("cat") String cat) {
		
		return proser.getByCategory(cat);
	}

	@GetMapping("/products/out")
	public List<Products> getOutOfStockProducts() {
	
		return proser.getOutOfStock();
	}

	@GetMapping("/products")
	public List<Products> findAllProducts() {
		
		return proser.findAll();
	}

	@GetMapping("/products/id/{id}")
	public Optional<Products> findProductsById(@PathVariable("id") int id) {
		
		return proser.findById(id);
	}

	@PostMapping("/products")
	public Products addProducts(@RequestBody Products pro) {
		
		return proser.save(pro);
	}
	
	@PutMapping("/products")
	public Products UpdateProducts(@RequestBody Products pro) {
		
		return proser.save(pro);
	}

	@DeleteMapping("/products/{id}")
	public String deleteById(@PathVariable("id") int id) {
		proser.deleteById(id);
		return "Deleted succesfully for id: " + id;
		
	}
}
