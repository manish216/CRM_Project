package com.wct.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestDbServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		setup database connection 
		
		String user = "springstudent";
		String pass = "springstudent";
		
//		Database url Connection 
		
		String jdbcurl = "jdbc:mysql://localhost:3306/web_customer_tracker?allowPublicKeyRetrieval=true&useSSL=false&serverTimeZone=UTC";
		String driver =  "com.mysql.cj.jdbc.Driver";
		
//		get connection to database
		
		try {
			PrintWriter out = response.getWriter();
			
			out.println("Connecting to database: "+ jdbcurl);
			
			out.println();
			Class.forName(driver);
			
			Connection myconnection = DriverManager.getConnection(jdbcurl,user,pass);
			
			out.println("Connection sucessfull !!!");
			
			myconnection.close();
			
		}catch (Exception exe) {
			exe.printStackTrace();
			throw new ServletException(exe);
		}
		
		
	}

}
