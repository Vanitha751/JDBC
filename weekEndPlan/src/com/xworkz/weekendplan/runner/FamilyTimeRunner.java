package com.xworkz.weekendplan.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xworkz.weekendplan.constants.ConnectionData;

public class FamilyTimeRunner {
	public static void main(String[] args) {
	String query1="SELECT * FROM weekendplan_table WHERE food = '?'";
	try(Connection connection=DriverManager.getConnection
			(ConnectionData.URL.getValue(), 
			ConnectionData.USERNAME.getValue(), 
			ConnectionData.PASSWORD.getValue());
	PreparedStatement preparedStatement=connection.prepareStatement(query1);){
		System.out.println("class is connected");
        ResultSet rs=preparedStatement.executeQuery();
		while(rs.next()) {
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+
				" "+rs.getString(4)+" "+rs.getInt(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8));	
		}
	}catch(SQLException exception) {
		exception.printStackTrace();
	}
	}
	
	
}
