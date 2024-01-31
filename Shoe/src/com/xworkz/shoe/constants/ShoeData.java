package com.xworkz.shoe.constants;

public enum ShoeData {
	URL("jdbc:mysql://localhost:3306/shoe_connection"),USERNAME("root"),PASSWORD("X-workzodc@123");
 
	private String value;
    public String getValue() {
		return value;
    }
     
    private ShoeData(String value) {
    this.value=value;
    }	
}
