/* Author: La Vo Minh Quan
 * 
 * */
package com.iuh.nhom12.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iuh.nhom12.dao.CustomerDAO;
import com.iuh.nhom12.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> findAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		List<Customer> customers = theQuery.getResultList();
		return customers;
	}

	@Override
	public Customer findById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer customer = currentSession.get(Customer.class, id);
		return customer;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(customer);
	}

	@Override
	public void deleteById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", id);
		theQuery.executeUpdate();
	}

	@Override
	public Customer findByUsernameAndEmail(String userName, String email) {
		Session currentSession = sessionFactory.getCurrentSession();
		String sql = "select * from customers where username = ?1 and email = ?2";
		NativeQuery<Customer> nativeQuery = currentSession.createNativeQuery(sql, Customer.class);
		
		nativeQuery.setParameter(1, userName);
		nativeQuery.setParameter(2, email);
		
		Customer customer = nativeQuery.getSingleResult();
		
		return customer;
	}
	
	@Override
	public Customer findByUser(String userName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> theQuery = currentSession.createQuery("from Customer where username = :userName", Customer.class);
		theQuery.setParameter("userName", userName);
		Customer customer = theQuery.getSingleResult();
		return customer;
	}

}
