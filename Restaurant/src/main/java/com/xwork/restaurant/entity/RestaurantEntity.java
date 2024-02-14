package com.xwork.restaurant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="restaurant_table")
public class RestaurantEntity {
	@Id
    @Column(name="id")
	private int id;
    @Column(name="restaurant_name")
	private String name;
    @Column(name="location")
	private String location;
    @Column(name="food_item")
	private String food_item;
	
}
