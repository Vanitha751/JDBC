package com.xworkz.school.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SchoolRunner {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/Schoolconnection";
		String userName="root";
		String passWord="Xworkzodc@123";
		try {
			Connection connection=DriverManager.getConnection(url, userName, passWord);
			if(connection!=null) {
				System.out.println("Connected successfully");
			}else {
				System.out.println("Connection is failed");
			}
		}catch(SQLException exception) {
			exception.printStackTrace();
			  System.out.println("catch block");
			}
}}
