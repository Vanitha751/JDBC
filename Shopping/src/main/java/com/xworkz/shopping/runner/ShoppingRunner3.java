package com.xworkz.shopping.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.xworkz.shopping.entity.ShoppingEntity;

public class ShoppingRunner3 {

	public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("com.xworkz");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction=entityManager.getTransaction();
    System.out.println("connected");
    try {
    	entityTransaction.begin();
    	ShoppingEntity shoppingEntity=new ShoppingEntity();
    	shoppingEntity.setId(4);
    	shoppingEntity.setShop_name("ABC");
    	shoppingEntity.setLocation("chickpet");
    	shoppingEntity.setItems("item2");
    	entityManager.persist(shoppingEntity);
    	entityTransaction.commit();
    }catch(PersistenceException e) {
    	if(entityTransaction.isActive()) {
    		entityTransaction.rollback();
    	}
    }finally {
		entityManagerFactory.close();
		entityManager.close();
	}
	}

}
