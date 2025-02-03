package com.example.pro.Service;

import java.util.List;

import com.example.pro.Entity.Order;
import com.example.pro.Entity.orderStatusEnum;

public interface orderService {

	void updateStatus(int id, orderStatusEnum status);

	List<Order> getByName(String name);

	Order save(Order or);

	List<Order> getAll();

	Order getById(int id);

	void deleteById(int id);

}
