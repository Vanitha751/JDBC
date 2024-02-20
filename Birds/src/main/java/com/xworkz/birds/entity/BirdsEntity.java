package com.xworkz.birds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="birds_Table")
@NamedQuery(name="updateBy",query="UPDATE BirdsEntity entity SET entity.location=:locationBy where entity.name=:birdNameBy")
@NamedQuery(name="age",query="UPDATE BirdsEntity entity SET entity.location=:locationBy where entity.age=:ageBy")
@NamedQuery(name="update",query="UPDATE BirdsEntity entity SET entity.name=:birdNameBy where entity.location=:locationBy")
@NamedQuery(name="updateFrom",query="UPDATE BirdsEntity entity SET entity.location=:locationBy where entity.name=:birdNameBy")
@NamedQuery(name="updateLocation",query="UPDATE BirdsEntity entity SET entity.location=:locationBy where entity.location=:locationName")
public class BirdsEntity {
@Id
@Column(name="birds_id")
	private int id;
@Column(name="birds_name")
	private String name;
@Column(name="age")
	private int age;
@Column(name="location")
	private String location; 
}
