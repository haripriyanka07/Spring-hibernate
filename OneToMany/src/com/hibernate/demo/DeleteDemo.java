package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Vendor;
import com.hibernate.demo.entity.VendorDetails;

public class DeleteDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Vendor.class)
								.addAnnotatedClass(VendorDetails.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Deleting");
			
			//start a transaction
			session.beginTransaction();
			
			Vendor vn = session.get(Vendor.class, 1);
			
			if(vn!=null) {
				
				System.out.println("Deleted!");
				session.delete(vn);
			}
			//commit transaction
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
			
		}

	}

}
