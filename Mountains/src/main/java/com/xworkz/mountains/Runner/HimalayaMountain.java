package com.xworkz.mountains.Runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.xworkz.mountains.constant.ConnectionData;

public class HimalayaMountain {
	public static void main(String[] args) {
		String query="INSERT INTO mountain_table(mountain_name,location)VALUES(?,?)";
	try(Connection connection=DriverManager.getConnection(ConnectionData.URL.getData(),
				ConnectionData.USERNAME.getData(), ConnectionData.PASSWORD.getData());
				PreparedStatement preparedStatement=connection.prepareStatement(query);){
			System.out.println("connected successfully");
			preparedStatement.setString(1,"Annapurna");
			preparedStatement.setString(2, "annapurna");
			preparedStatement.addBatch();
			
			preparedStatement.setString(1," Lhotse");
			preparedStatement.setString(2, "china");
			preparedStatement.addBatch();
			
			preparedStatement.setString(1,"Tirumala");
			preparedStatement.setString(2, "Tirupati");
			preparedStatement.addBatch();
			
			preparedStatement.setString(1,"himalaya");
			preparedStatement.setString(2, "Asia");
			preparedStatement.addBatch();
			
			preparedStatement.executeBatch();
	}catch(SQLException exception) {
		exception.printStackTrace();
	}
	}
}
