package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Vendor;
import com.hibernate.demo.entity.VendorDetails;

public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Vendor.class)
								.addAnnotatedClass(VendorDetails.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new User");
			
			Vendor vendor = new Vendor("Parle", "9834512764", "PRL52");
			
			VendorDetails VD = new VendorDetails("Street 9");
			
			//associate the objects
			vendor.setVendorDetails(VD);
			
			//start a transaction
			session.beginTransaction();
			
			//save the vendor
			session.save(vendor);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Creation done successfully!");
		}
		finally {
			factory.close();
			
		}

	}

}
