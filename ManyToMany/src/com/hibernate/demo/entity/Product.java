package com.hibernate.demo.entity;

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
		
	// if we delete a product we should not delete the vendor
//	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
//	@JoinColumn(name="VendorID")
//	private Vendor Vendor;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="ProductID")
	private List<Review> reviews;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(name="ProductVendor", joinColumns=@JoinColumn(name="ProductID"), inverseJoinColumns=@JoinColumn(name="VendorID"))
	private List<Vendor> vendor;
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
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

	public Product() {
		
	}
	public void addReview(Review temp) {
		if(reviews == null) {
			reviews = new ArrayList<>();
		}
		reviews.add(temp);
	}
	
	public List<Vendor> getVendor(){
		return vendor;
	}

	public void setVendor(List<Vendor> vendor) {
		this.vendor = vendor;
	}
	
	//convenience method
	
	public void addVendor(Vendor temp) {
		if(vendor == null) {
			vendor = new ArrayList<>();
		}
		vendor.add(temp);
	}
}
