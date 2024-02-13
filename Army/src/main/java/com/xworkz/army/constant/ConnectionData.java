package com.xworkz.army.constant;

public enum ConnectionData {
URL("jdbc:mysql://localhost:3306/army"),USERNAME("root"),PASSWORD("X-workzodc@123");
	
	private String data;

	ConnectionData(String data) {
		this.data=data;
	}

	public String getData() {
		return data;
	}
}
