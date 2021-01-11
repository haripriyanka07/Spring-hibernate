package com.web.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.entity.Product;


@Repository
public class ProductDAOImpl implements ProductDAO {
	
	//Session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> getProducts() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Product> query = session.createQuery("from Product order by Name", Product.class);
		
		List<Product> products = query.getResultList();
		System.out.println(products);
		
		return products;
	}

	@Override
	public void saveProduct(Product product) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(product);
		
	}

	@Override
	public Product getProduct(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Product prod = session.get(Product.class, id);
		
		return prod;
	}

	@Override
	public void deleteProduct(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("delete from Product where id=:id");
		
		query.setParameter("id", id);
		
		query.executeUpdate();
	}

}
