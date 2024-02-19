package com.xworkz.temples.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="temple_table")
public class TempleEntity {

	@Id
	@Column(name="id")
	private int id;
	@Column(name="temple_name")
	private String name;
	@Column(name="temple_location")
	private String location;
	@Column(name="ticket_price")
	private int ticketPrice;
	@Column(name="offerings")
	private int offerings;
	
}