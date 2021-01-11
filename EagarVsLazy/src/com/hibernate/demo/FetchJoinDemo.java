package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.demo.entity.Product;
import com.hibernate.demo.entity.Vendor;
import com.hibernate.demo.entity.VendorDetails;

public class FetchJoinDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Vendor.class)
								.addAnnotatedClass(VendorDetails.class)
								.addAnnotatedClass(Product.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new User");
			
			//start a transaction
			session.beginTransaction();
			
			Query<Vendor> query = session.createQuery("select i from Vendor i join fetch i.products where i.id=:vendorid", Vendor.class);
			
			query.setParameter("vendorid", 3);
			
			Vendor ven = query.getSingleResult();
			
			System.out.println("Vendor " +ven);
			
			//commit transaction
			session.getTransaction().commit();
			session.close();
			System.out.println("\n session is closed \n");
			System.out.println(ven.getProducts());
			
			System.out.println("Creation done successfully!");
		}
		finally {
			factory.close();
			
		}

	}

}
