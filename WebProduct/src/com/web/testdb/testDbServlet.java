package com.web.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testDbServlet
 */
@WebServlet("/testDbServlet")
public class testDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = "hari";
		String password = "Sbma@0338";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/Store?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			PrintWriter out = response.getWriter();
			
			out.println("connecting to database: "+jdbcUrl);
			
			Class.forName(driver);
			
			Connection connect = DriverManager.getConnection(jdbcUrl, user, password);
			
			out.println("Connection Successfull!!!");
			
			connect.close();
		}
		catch(Exception ec) {
			ec.printStackTrace();
			throw new ServletException(ec);
		}
	}

}
