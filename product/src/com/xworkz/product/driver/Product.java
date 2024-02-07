package com.xworkz.product.driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.xworkz.product.constant.ConnectData;

public class Product {

	public static void main(String[] args) {
		
		String query="INSERT INTO product_table(S.no,product_name,product_price,employee_salary,department)VALUES(?,?,?,?,?)";
		
		try(Connection connection=DriverManager.getConnection(ConnectData.URL.getData(), ConnectData.USERNAME.getData(), 
	        ConnectData.PASSWORD.getData());
		    PreparedStatement preparedStatement=connection.prepareStatement(query)){
			 System.out.println("connected successfully");
			preparedStatement.setInt(1, 1);
			preparedStatement.setString(2, "bag");
			preparedStatement.setInt(3,100);
			preparedStatement.setInt(4,50000);
			preparedStatement.setString(5,"Non-IT");
			preparedStatement.addBatch();
			
			preparedStatement.setInt(1, 2);
			preparedStatement.setString(2, "abc");
			preparedStatement.setInt(3,200);
			preparedStatement.setInt(4,5000);
			preparedStatement.setString(5,"IT");
			preparedStatement.addBatch();
			
	        preparedStatement.executeBatch();
	        
		}catch(SQLException exception) {
			exception.printStackTrace();
		}
	}

}
