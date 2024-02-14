package com.xworkz.shopping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="shopping_table")
public class ShoppingEntity {

  @Id
  @Column(name="shopping_id")
  private  int id;
  @Column(name="shop_name")
  private String shop_name;
  @Column(name="location")
  private String location;
  @Column(name="items")
  private String items;
  
} 