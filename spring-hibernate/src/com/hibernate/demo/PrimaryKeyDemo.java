package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Users;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Users.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new User");
			Users user = new Users("Harry", "1234", "Customer");
			Users user1 = new Users("Vector", "5678", "Customer");
			Users user2 = new Users("Denver", "9234", "Customer");
			
			session.beginTransaction();
			
			session.save(user);
			session.save(user1);
			session.save(user2);
			
			session.getTransaction().commit();
			
			System.out.println("Creating don successfully!");
		}
		finally {
			factory.close();
		
		}

	}

}
