package com.xworkz.shoe.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.xworkz.shoe.constants.ShoeData;
public class ShoeRunner {
public static void main(String[] args) {
	try(Connection connection=DriverManager.getConnection
			(ShoeData.URL.getValue(),
			ShoeData.USERNAME.getValue(),
			ShoeData.PASSWORD.getValue()
			);
			Statement statement=connection.createStatement()){
			System.out.println("class is connected");
			String query="insert into shoe_details values(1,'cycling_shoes','good')";
			String query1="update shoe_details set shoe_name='monk'where shoe_name='cycling_shoes'";
			statement.execute(query);
			int row=statement.executeUpdate(query1);
			if(row==1) {
				System.out.println("this is updated");
			}else {
				System.out.println("this is not updated");
			}
	}
		catch(SQLException exception) {
			System.out.println("class is not connected");
			exception.printStackTrace();
		}
	}
}