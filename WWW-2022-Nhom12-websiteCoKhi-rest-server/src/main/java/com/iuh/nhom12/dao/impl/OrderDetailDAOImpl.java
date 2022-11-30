package com.iuh.nhom12.dao.impl;

import java.util.List; 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iuh.nhom12.dao.OrderDetailDAO;
import com.iuh.nhom12.entity.OrderDetail;

/*
 * Author: Nguyen Hong Quan
 */
@Repository
public class OrderDetailDAOImpl implements OrderDetailDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<OrderDetail> findAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<OrderDetail> theQuery = currentSession.createQuery("from OrderDetail", OrderDetail.class);
		List<OrderDetail> orderDetails = theQuery.getResultList();
		return orderDetails;
	}

	@Override
	public OrderDetail findById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		OrderDetail orderDetail = currentSession.get(OrderDetail.class, id);
		return orderDetail;
	}

	@Override
	public void saveOrderDetail(OrderDetail orderDetail) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(orderDetail);
	}
	
	@Override
	public void deleteOrderDetail(int orderId, int productId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from OrderDetail where order.id=:orderId and product.id=:productId");
		query.setParameter("orderId", orderId);
		query.setParameter("productId", productId);
		query.executeUpdate();
	}
	
	@Override
	public List<OrderDetail> findAllByOrderId(int orderId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<OrderDetail> theQuery = currentSession.createQuery("from OrderDetail where order.id =:orderId", OrderDetail.class); 
		theQuery.setParameter("orderId", orderId);
		List<OrderDetail> listOrderDetails = theQuery.getResultList();
		return listOrderDetails;
	}
	
}
