package com.xworkz.tirupathi.car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.xworkz.tirupathi.constants.ConnectionData;

public class Car {

	public static void main(String[] args) throws SQLException {

		String query="INSERT INTO car_table(car_name,price,model)VALUES(?,?,?)";
		
		Connection connection=DriverManager.getConnection(ConnectionData.URL.getData(),
				ConnectionData.USERNAME.getData(), ConnectionData.PASSWORD.getData());
				PreparedStatement preparedStatement=connection.prepareStatement(query);
			System.out.println("connected successfully");
				
			    preparedStatement.setString(1,"Suzuki");
				preparedStatement.setInt(2,250000);
				preparedStatement.setString(3,"2023M");
				preparedStatement.addBatch();
				
				preparedStatement.setString(1,"BMW");
				preparedStatement.setInt(2,500000);
				preparedStatement.setString(3,"2020M");
				preparedStatement.addBatch();
				
				preparedStatement.setString(1,"ford");
				preparedStatement.setInt(2,25000000);
				preparedStatement.setString(3,"2000M");
				preparedStatement.addBatch();
				
				preparedStatement.setString(1,"Nexon");
				preparedStatement.setInt(2,60000000);
				preparedStatement.setString(3,"2023M");
				preparedStatement.addBatch();
				
				preparedStatement.executeBatch();		
				
	}
}
