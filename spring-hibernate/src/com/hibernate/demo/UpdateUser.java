package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Users;

public class UpdateUser {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Users.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Updating User");
			
			session.beginTransaction();
			
			Users user = session.get(Users.class,  3);
			
			user.setUsername("vector1");
			
			session.getTransaction().commit();
			
//			System.out.println("successful!");
		}
		finally {
			factory.close();
			
		}

	}

}
