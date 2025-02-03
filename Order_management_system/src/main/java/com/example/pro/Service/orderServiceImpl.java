package com.example.pro.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pro.Entity.Order;
import com.example.pro.Entity.orderStatusEnum;
import com.example.pro.Repository.orderDao;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class orderServiceImpl implements orderService {
	
	@Autowired
	private orderDao orDao;
	
	@Override
	public void updateStatus(int id, orderStatusEnum status) {
		orDao.updateStatus(id, status);
		
	}

	@Override
	public List<Order> getByName(String name) {
		
		return orDao.getByName(name);
	}

	@Override
	public Order save(Order or) {
		
		return orDao.save(or);
	}

	@Override
	public List<Order> getAll() {
		
		return orDao.getAll();
	}

	@Override
	public Order getById(int id) {
		
		return orDao.getById(id);
	}

	@Override
	public void deleteById(int id) {
		orDao.deleteById(id);
		
	}

}
