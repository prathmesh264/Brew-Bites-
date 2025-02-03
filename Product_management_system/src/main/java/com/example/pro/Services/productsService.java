package com.example.pro.Services;

import java.util.List;
import java.util.Optional;

import com.example.pro.Entity.Products;

public interface productsService {

	List<Products> getByCategory(String cat);

	List<Products> getOutOfStock();
	
	List<Products> findAll();
	
	Optional<Products> findById(int id);
	
	Products save(Products pro);
	
	void deleteById(int id);
	
	

}
