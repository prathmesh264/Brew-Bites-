package com.example.pro.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.pro.Entity.Order;
import com.example.pro.Entity.orderStatusEnum;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class ordersDaoImpl implements orderDao{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void updateStatus(int id, orderStatusEnum status) {
		entityManager.createQuery("update Order set status=:Data where id =:DataId")
		.setParameter("Data", status)
		.setParameter("DataId", id)
		.executeUpdate();
		
	}

	@Override
	public List<Order> getByName(String name) {
		TypedQuery<Order> query = entityManager.createQuery("from Order where customerName=:Data", Order.class);
		query.setParameter("Data", name);
		return query.getResultList();
	}

	@Override
	public Order save(Order or) {
		
		return entityManager.merge(or);
	}

	@Override
	public List<Order> getAll() {
		TypedQuery<Order> query = entityManager.createQuery("from Order", Order.class);
		
		return query.getResultList();
	}

	@Override
	public Order getById(int id) {
		Order orget = entityManager.find(Order.class, id);
		return orget;
	}

	@Override
	public void deleteById(int id) {
		Order orget = entityManager.find(Order.class, id);
		
		entityManager.remove(orget);
		
	}

}
