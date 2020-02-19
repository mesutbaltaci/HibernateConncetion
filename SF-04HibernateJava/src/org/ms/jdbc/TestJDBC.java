package org.ms.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	
	public static void main(String[] args) {
		String jdbcUrl= "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user= "mesut";
		String pass = "1234";
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection myConnection = DriverManager.getConnection(jdbcUrl,user,pass);
			
			System.out.println("Conncetion succesfull!!!");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
