package com.example.pro.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pro.Entity.Products;
import com.example.pro.Repository.productsRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class productsServiceImpl implements productsService{
	
	@Autowired
	private productsRepository repo;

	@Override
	public List<Products> getByCategory(String cat) {
		// TODO Auto-generated method stub
		return repo.getByCategory(cat);
	}

	@Override
	public List<Products> getOutOfStock() {
		// TODO Auto-generated method stub
		return repo.getOutOfStock();
	}

	@Override
	public List<Products> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<Products> findById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Products save(Products pro) {
		// TODO Auto-generated method stub
		return repo.save(pro);
	}

	@Override
	public void deleteById(int id) {
		repo.deleteById(id);
		
	}

}
