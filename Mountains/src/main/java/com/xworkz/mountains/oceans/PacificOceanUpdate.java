package com.xworkz.mountains.oceans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.xworkz.mountains.constant.ConnectionData;

public class PacificOceanUpdate{
public static void main(String[] args) {
	String query="UPDATE mountain_table set mountain_name=? where location=?";
	try(Connection connection=DriverManager.getConnection(ConnectionData.URL.getData(), ConnectionData.USERNAME.getData(), 
			ConnectionData.PASSWORD.getData());
    		PreparedStatement preparedStatement=connection.prepareStatement(query);){
		preparedStatement.setString(1,"AtlanticOcean");
		preparedStatement.setString(2,"asia");
    	
    	preparedStatement.executeUpdate();
    	
    	System.out.println("update");
	}catch(SQLException e) {
		e.printStackTrace();
		
	}
}
}
