package com.web.service;

import java.util.List;

import com.web.entity.Product;

public interface ProductService {
	
	public List<Product> getProducts();

	public void saveProduct(Product product);

	public Product getProducts(int id);

	public void deleteProduct(int id);
}
