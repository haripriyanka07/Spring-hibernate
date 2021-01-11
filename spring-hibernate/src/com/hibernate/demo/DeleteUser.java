package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Users;

public class DeleteUser {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Users.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Removing User");
			
			session.beginTransaction();
			
			session.createQuery("delete from Users where id=2").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("successful!");
		}
		finally {
			factory.close();
			
		}

	}

}
