package com.example.pro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pro.Entity.Products;
import com.example.pro.Repository.CustomDao.productsDao;

@Repository
public interface productsRepository extends JpaRepository<Products, Integer>, productsDao{

}
