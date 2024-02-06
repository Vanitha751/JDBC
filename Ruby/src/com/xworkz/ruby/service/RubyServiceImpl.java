package com.xworkz.ruby.service;

import com.xworkz.ruby.dto.RubyDto;
import com.xworkz.ruby.repo.RubyRepo;
import com.xworkz.ruby.repo.RubyRepoImpl;

public class RubyServiceImpl implements RubyService{
	
		@Override
		public boolean save(RubyDto dto) {
     	RubyRepo repo=new RubyRepoImpl();
		boolean saved=repo.save(dto);
	
		System.out.println("The value is saved in service implementation:"+saved);
		return true;
		}
		}

