package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Vendor;
import com.hibernate.demo.entity.VendorDetails;

public class DeleteVendorDetailDemo {

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
			
			VendorDetails vendorD = session.get(VendorDetails.class, 3);
			
			System.out.println("Details "+vendorD.getVendor());
			
			
			vendorD.getVendor().setVendorDetails(null);
			
			session.delete(vendorD);
			//commit transaction
			session.getTransaction().commit();
			
		}
		catch(Exception ex) {
			ex.printStackTrace();			
		}
		finally {
			session.close();
			factory.close();
			
		}

	}

}
