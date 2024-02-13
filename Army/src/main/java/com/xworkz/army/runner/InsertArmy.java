package com.xworkz.army.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.xworkz.army.constant.ConnectionData;

public class InsertArmy {
	public static void main(String[] args) {
		String query="INSERT INTO armyunit(unitid,unitname,location,COMMANDERRANK)VALUES(?,?,?,?)";
		try(Connection connection=DriverManager.getConnection(ConnectionData.URL.getData(),
					ConnectionData.USERNAME.getData(), ConnectionData.PASSWORD.getData());
					PreparedStatement preparedStatement=connection.prepareStatement(query);){
				System.out.println("connected successfully");
				preparedStatement.setInt(1,9);
				preparedStatement.setString(2,"A");
				preparedStatement.setString(3, "tpt");
				preparedStatement.setString(4,"sv143");
				preparedStatement.addBatch();
				
				preparedStatement.setInt(1,10);
				preparedStatement.setString(2,"B");
				preparedStatement.setString(3, "kadapa");
				preparedStatement.setString(4,"sv143");
				preparedStatement.addBatch();
				
				preparedStatement.executeBatch();
		}catch(SQLException exception) {
			exception.printStackTrace();
		}
	}
}
