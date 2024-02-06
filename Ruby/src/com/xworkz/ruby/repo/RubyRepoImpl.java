package com.xworkz.ruby.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.xworkz.ruby.constants.ConnectionData;
import com.xworkz.ruby.dto.RubyDto;

public class RubyRepoImpl implements RubyRepo {

	@Override
	public boolean save(RubyDto dto) {
			System.out.println("this is repository class");
			String query="INSERT INTO Stone_table(name,weight,colour,height,price,quality,noOfstones,location,availableIn,famous)values(?,?,?,?,?,?,?,?,?,?)";
			try(Connection connection=DriverManager.getConnection(ConnectionData.URL.getValue(),ConnectionData.USERNAME.getValue(),ConnectionData.PASSWORD.getValue());
			PreparedStatement preparedstatement=connection.prepareStatement(query)){
				preparedstatement.setString(1,dto.getName());
				preparedstatement.setInt(2,dto.getWeight());
				preparedstatement.setString(3,dto.getColour());
			preparedstatement.setFloat(4,dto.getHeight());
			preparedstatement.setInt(5,dto.getPrice());
			preparedstatement.setString(6,dto.getQuality());
			preparedstatement.setInt(7,dto.getNoOfStones());
			preparedstatement.setString(8,dto.getLocation());
			preparedstatement.setBoolean(9,dto.isAvailableIn());
			preparedstatement.setBoolean(10,dto.isFamous());
            System.out.println("Repository impementation is running");
			preparedstatement.executeUpdate();
			}catch(SQLException exception){
			exception.printStackTrace();
	}
			return true;

}
}
