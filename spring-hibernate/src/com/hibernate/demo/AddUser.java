package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Users;

public class AddUser {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Users.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new User");
			Users user = new Users("Hari", "Hari", "Admin");
			
			session.beginTransaction();
			
			session.save(user);
			
			session.getTransaction().commit();
			
			System.out.println("Creating don successfully!");
		}
		finally {
			factory.close();
			
		}

	}

}
