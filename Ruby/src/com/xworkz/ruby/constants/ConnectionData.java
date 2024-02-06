package com.xworkz.ruby.constants;

public enum ConnectionData {
   URL("jdbc:mqsql://localhost:3306/stone"),USERNAME("root"),PASSWORD("X-workzodc@123");
	
	private String value;
	
	ConnectionData(String value) {
		this.value=value;
	}
	
	public String getValue() {
		return value;
	}
}
