package com.example.pro.Repository.CustomDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.pro.Entity.Products;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class productsDaoImpl implements productsDao{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Products> getByCategory(String cat) {
		TypedQuery<Products> query = entityManager.createQuery("from Products where category=:Data", Products.class);
		query.setParameter("Data", cat);
		return query.getResultList();
	}

	@Override
	public List<Products> getOutOfStock() {
		TypedQuery<Products> query = entityManager.createQuery("from Products where stock = 0", Products.class);
		
		return query.getResultList();
	}

}
