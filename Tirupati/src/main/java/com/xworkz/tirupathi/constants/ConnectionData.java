package com.xworkz.tirupathi.constants;

public enum ConnectionData {

    URL("jdbc:mysql://localhost:3306/car_database"),USERNAME("root"),PASSWORD("X-workzodc@123");
	
	private String data;

	ConnectionData(String data) {
		this.data=data;
	}

	public String getData() {
	}
}
