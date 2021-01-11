package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Product;
import com.hibernate.demo.entity.Review;
import com.hibernate.demo.entity.Vendor;
import com.hibernate.demo.entity.VendorDetails;

public class Delete {

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
			System.out.println("Deleting");
			
			//start a transaction
			session.beginTransaction();
			
			Vendor vn = session.get(Vendor.class, 3);
			
//			System.out.println(vn.getProducts());
			
			session.delete(vn);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Creation done successfully!");
		}
		finally {
			factory.close();
			
		}

	}

}
