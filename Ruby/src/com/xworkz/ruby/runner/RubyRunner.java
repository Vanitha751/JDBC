package com.xworkz.ruby.runner;

import com.xworkz.ruby.dto.RubyDto;
import com.xworkz.ruby.service.RubyService;
import com.xworkz.ruby.service.RubyServiceImpl;

public class RubyRunner {
public static void main(String[] args) {
	System.out.println("Runner class is running");
	
	RubyServiceImpl service=new RubyServiceImpl();
	RubyDto dto=new RubyDto();
	service.save(dto);
	dto.setName("value1");
	dto.setWeight(200);
	dto.setColour("green");
	dto.setHeight(2.01f);
	dto.setPrice(500);
	dto.setQuality("good");
	dto.setNoOfStones(5);
	dto.setLocation("tpt");
	dto.setAvailableIn(true);
	dto.setFamous(false);
}
}
