package com.xworkz.army.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xworkz.army.constant.ConnectionData;

public class ReadArmy {
	public static void main(String[] args) {
		
	String query="SELECT unitname,location FROM armyunit where id=?";
	try(Connection connection=DriverManager.getConnection(ConnectionData.URL.getData(), ConnectionData.USERNAME.getData(), 
			ConnectionData.PASSWORD.getData());
    		PreparedStatement preparedStatement=connection.prepareStatement(query);){
		preparedStatement.setInt(1, 3);

		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));			
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
}
}