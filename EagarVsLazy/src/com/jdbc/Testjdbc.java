package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Testjdbc {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/Store?useSSL=false";
		String user = "hari";
		String password = "Sbma@0338";
		try {
			
			System.out.println("Connecting "+url);
			
			Connection con = DriverManager.getConnection(url, user, password);
			
			System.out.println("Connection successfull");
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
