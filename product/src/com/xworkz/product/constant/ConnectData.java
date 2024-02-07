package com.xworkz.product.constant;

public enum ConnectData {
URL("jdbc:mqsql://loacalhost:3306/product_database"),USERNAME("root"),PASSWORD("X-workzodc@123");
	
	private String data;

	ConnectData(String data) {
		this.data=data;
	}

	public String getData() {
		return data;
	}

}
