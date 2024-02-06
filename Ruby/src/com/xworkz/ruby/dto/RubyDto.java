package com.xworkz.ruby.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class RubyDto {

	private String name;
	private int weight;
	private String colour;
	private float height;
	private int price;
	private String quality;
	private int noOfStones;
	private String location;
	private boolean availableIn;
	private boolean famous;
	
	
}
