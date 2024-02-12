package com.xworkz.birthday.driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.xworkz.birthday.constant.ConnectionData;


public class BirthdayParty {
public static void main(String[] args) throws SQLException {
	String query="INSERT INTO birthday_table(name,location,age)VALUES(?,?,?)";
	Connection connection=DriverManager.getConnection(ConnectionData.URL.getData(),
			ConnectionData.USERNAME.getData(), ConnectionData.PASSWORD.getData());
			PreparedStatement preparedStatement=connection.prepareStatement(query);
		System.out.println("connected successfully");
		
		preparedStatement.setString(1,"vanitha");
		preparedStatement.setString(2, "tpt");
		preparedStatement.setInt(3, 21);
		preparedStatement.addBatch();
		
		preparedStatement.setString(1,"shivani");
		preparedStatement.setString(2, "kadapa");
		preparedStatement.setInt(3, 22);
		preparedStatement.addBatch();
		
		preparedStatement.setString(1,"kavya");
		preparedStatement.setString(2, "pandychery");
		preparedStatement.setInt(3,3) ;
		preparedStatement.addBatch();
		
		preparedStatement.setString(1,"hima");
		preparedStatement.setString(2, "daminedu");
		preparedStatement.setInt(3,3);
		preparedStatement.addBatch();
		
		preparedStatement.executeBatch();
}
}
