package com.xworkz.crops.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="crops_table")
//@NamedQuery(name="updateBy",query="UPDATE CropsEntity entity SET entity.location=:locationBy where entity.cropName=:cropNameBy")
public class CropsEntity {
	@Id
    @Column(name="crop_id")
	private int id;
	@Column(name="crop_name")
	private String cropName;
	@Column(name="location")
	private String location;
	@Column(name="price")
	private int price;
}
