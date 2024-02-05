package com.xworkz.weekendplan.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xworkz.weekendplan.constants.ConnectionData;

public class WeekEndPlan1 {

	public static void main(String[] args) {
	//	String query="INSERT INTO weekendplan_table (S.no,place,travelling_in,price,food)values(?,?,?,?,?)";
		String query1="SELECT * FROM weekendplan_table WHERE place = '?'";
		try(Connection connection=DriverManager.getConnection
				(ConnectionData.URL.getValue(), 
				ConnectionData.USERNAME.getValue(), 
				ConnectionData.PASSWORD.getValue());
		PreparedStatement preparedStatement=connection.prepareStatement(query1);)
		{
			
//		preparedStatement.setInt(1, 1);
//		preparedStatement.setString(2,"value1");
//		preparedStatement.setString(3,"value2");
//		preparedStatement.setInt(4,20);
//		preparedStatement.setString(5,"value3");
//		preparedStatement.setString(6,"value4");
//	    preparedStatement.setString(7,"value5");
        System.out.println("class is connected");
        ResultSet rs=preparedStatement.executeQuery();
		while(rs.next()) {
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+
				" "+rs.getString(4)+" "+rs.getInt(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8));	
		}
	}catch(SQLException exception) {
		exception.printStackTrace();
	}
}}