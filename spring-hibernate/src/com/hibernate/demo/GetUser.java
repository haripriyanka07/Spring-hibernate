package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Users;

public class GetUser {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Users.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("fetching new User");
			
			session.beginTransaction();
			
			List<Users> users = session.createQuery("from Users s where s.username='Hari' and s.password='Hari'").list();
			
			if(users.size()==1) {
				for(Users user:users) {
					System.out.println(user);
				}
				System.out.println("Login successfull");
			}
			else {
				System.out.println("Please Enter correct details");
			}
			
			session.getTransaction().commit();
			
//			System.out.println("successful!");
		}
		finally {
			factory.close();
			
		}

	}

}
