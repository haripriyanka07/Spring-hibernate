package com.hibernate.demo.entity;

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
		
	// if we delete a product we should not delete the vendor
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="VendorID")
	private Vendor Vendor;
	
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

	public Vendor getVendor() {
		return Vendor;
	}

	public void setVendor(Vendor vendor) {
		System.out.println("Into vendor");
		Vendor = vendor;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", Name=" + Name + ", Rating=" + Rating + "]";
	}

	public Product() {
		
	}
}
