package com.web.dao;

import java.util.List;

import com.web.entity.Product;

public interface ProductDAO {
	
	public List<Product> getProducts();

	public void saveProduct(Product product);

	public Product getProduct(int id);

	public void deleteProduct(int id);
	
}
