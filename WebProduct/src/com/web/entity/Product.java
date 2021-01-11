package com.web.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Product")
public class Product {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="Name")
	private String Name;
	
	@Column(name="Rating")
	private int Rating;

	public Product() {
		
	}

	public Product(String name, int rating) {
		super();
		Name = name;
		Rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getRating() {
		return Rating;
	}

	public void setRating(int rating) {
		Rating = rating;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", Name=" + Name + ", Rating=" + Rating + "]";
	}
	
}
