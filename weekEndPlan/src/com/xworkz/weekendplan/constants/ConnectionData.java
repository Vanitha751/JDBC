package com.xworkz.weekendplan.constants;

public enum ConnectionData {

	URL("jdbc:mysql://localhost:3306/weekend_plan"),USERNAME("root"),PASSWORD("X-workzodc@123");

	private String value;
	
	public String getValue() {
		return value;
	}
	
   private ConnectionData(String value) {
		this.value=value;
	}
}
