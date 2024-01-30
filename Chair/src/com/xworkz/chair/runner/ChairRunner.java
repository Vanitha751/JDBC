package com.xworkz.chair.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ChairRunner {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/Chairconnection";
		String userName="root";
		String passWord="X-workzodc@123";
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
	}
}
