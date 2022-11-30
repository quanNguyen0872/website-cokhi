/* Author: Doan Thi My Linh
 * 
 * */
package com.iuh.nhom12.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iuh.nhom12.dao.ProductDAO;
import com.iuh.nhom12.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> findAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Product> theQuery = currentSession.createQuery("from Product", Product.class);
		List<Product> productList = theQuery.getResultList();
		return productList;
	}

	@Override
	public Product findById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Product product = currentSession.get(Product.class, id);
		return product;
	}

	@Override
	public void saveProduct(Product product) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(product);
		
	}

	@Override
	public void deleteById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Product where id=:productId");
		theQuery.setParameter("productId", id);
		theQuery.executeUpdate();
		
	}

}
