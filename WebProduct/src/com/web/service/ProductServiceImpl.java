package com.web.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dao.ProductDAO;
import com.web.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	
	@Override
	@Transactional
	public List<Product> getProducts() {
		return productDAO.getProducts();
	}


	@Override
	@Transactional
	public void saveProduct(Product product) {
		
		productDAO.saveProduct(product);
		
	}


	@Override
	@Transactional
	public Product getProducts(int id) {
		return productDAO.getProduct(id);
	}


	@Override
	@Transactional
	public void deleteProduct(int id) {
		productDAO.deleteProduct(id);
	}

}
