package com.iuh.nhom12.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iuh.nhom12.dao.CategoryDAO;
import com.iuh.nhom12.entity.Category;
import com.iuh.nhom12.entity.Product;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> findAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Category> theQuery = currentSession.createQuery("from Category", Category.class);
		List<Category> categories = theQuery.getResultList();
		return categories;
	}

	@Override
	public Category findById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Category category = currentSession.get(Category.class, id);
		return category;
	}

	@Override
	public void saveCategory(Category category) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(category);

	}

	@Override
	public void deleteById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Category where id=:categoryId");
		theQuery.setParameter("categoryId", id);
		theQuery.executeUpdate();
	}

	@Override
	public Category findByName(String name) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Category> theQuery = currentSession.createQuery("from Category where categoryName=:name", Category.class);
		theQuery.setParameter("name", name);
		Category category = theQuery.getSingleResult();
		return category;
	}

}
