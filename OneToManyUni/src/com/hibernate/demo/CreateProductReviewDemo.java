package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Product;
import com.hibernate.demo.entity.Review;
import com.hibernate.demo.entity.Vendor;
import com.hibernate.demo.entity.VendorDetails;

public class CreateProductReviewDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Vendor.class)
								.addAnnotatedClass(VendorDetails.class)
								.addAnnotatedClass(Product.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Saving");
			
			//start a transaction
			session.beginTransaction();
			
			Product temp = new Product("ChocoBic", 5);
			
			temp.addReview(new Review("very nice"));
			temp.addReview(new Review("Great taste"));
			temp.addReview(new Review("Poor"));
			
			System.out.println(temp);
			System.out.println(temp.getReviews());
			session.save(temp);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Creation done successfully!");
		}
		finally {
			factory.close();
			
		}

	}

}
