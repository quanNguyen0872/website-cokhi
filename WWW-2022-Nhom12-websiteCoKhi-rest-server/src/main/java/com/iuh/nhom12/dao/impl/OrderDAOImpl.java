package com.iuh.nhom12.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iuh.nhom12.dao.OrderDAO;
import com.iuh.nhom12.entity.Order;
/*
 * Author: Nguyen Hong Quan
 */
@Repository
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Order> findAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Order> theQuery = currentSession.createQuery("from Order", Order.class);
		List<Order> orderList = theQuery.getResultList();
		return orderList;
	}

	@Override
	public Order findById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Order order = currentSession.get(Order.class, id);
		return order;
	}

	@Override
	public void saveOrder(Order order) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(order);
	}
	
	@Override
	public void deleteById(int orderId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from Order where id=:orderId");
		query.setParameter("orderId", orderId);
		query.executeUpdate();
	}

	@Override
	public Order findByCustomerId(int customerId, int status) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Order> theQuery = currentSession.createQuery("from Order where customer.id =:customerId and status = :status", Order.class);
		theQuery.setParameter("customerId", customerId);
		theQuery.setParameter("status", status);
		Order order = theQuery.getSingleResult();
		return order;
	}

	@Override
	public List<Order> findAllByCustomerId(int customerId, int status) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Order> theQuery = currentSession.createQuery("from Order where customer.id =:customerId and status = :status", Order.class);
		theQuery.setParameter("customerId", customerId);
		theQuery.setParameter("status", status);
		List<Order> orders = theQuery.getResultList();
		return orders;
	}



}
