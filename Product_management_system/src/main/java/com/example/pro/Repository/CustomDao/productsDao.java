package com.example.pro.Repository.CustomDao;

import java.util.List;

import com.example.pro.Entity.Products;

public interface productsDao {
	
	List<Products> getByCategory(String cat);
	
	List<Products> getOutOfStock();

}
