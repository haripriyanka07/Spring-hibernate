package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.dao.ProductDAO;
import com.web.entity.Product;
import com.web.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/list")
	public String listProducts(Model model) {
		
		List<Product> products = productService.getProducts();
		
		model.addAttribute("products", products);
		
		return "list-products";
	}
	
	@GetMapping("/showForm")
	public String showProductForm(Model model) {
		
		Product pro = new Product();
		
		model.addAttribute("product", pro);
		
		return "product-form";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product product) {
		
		productService.saveProduct(product);
		
		return "redirect:/product/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String update(@RequestParam("productId") int id, Model model) {
		Product product = productService.getProducts(id);
		
		model.addAttribute("product", product);
		
		return "product-form";
	}
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("productId") int id) {
		
		productService.deleteProduct(id);
		
		return "redirect:/product/list";
	}
	
}
