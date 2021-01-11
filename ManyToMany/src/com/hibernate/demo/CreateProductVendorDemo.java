package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Product;
import com.hibernate.demo.entity.Review;
import com.hibernate.demo.entity.Vendor;
import com.hibernate.demo.entity.VendorDetails;

public class CreateProductVendorDemo {

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
			
			Product temp = new Product("chocowaffy", 3);
						
			System.out.println(temp);
			session.save(temp);
			
			
			Vendor ven = session.get(Vendor.class, 3);
			Vendor ven1 = session.get(Vendor.class, 4);
			
			temp.addVendor(ven);
			temp.addVendor(ven1);
			
			System.out.println("\nSaving..\n");
//			session.save(ven);
//			session.save(ven1);
//			
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Creation done successfully!");
		}
		finally {
			factory.close();
			
		}

	}

}
