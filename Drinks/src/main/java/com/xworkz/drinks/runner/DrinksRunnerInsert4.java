package com.xworkz.drinks.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.xworkz.drinks.entity.DrinksEntity;

public class DrinksRunnerInsert4 {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("com.xworkz");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	System.out.println("this is connected");
	
	try {
		entityTransaction.begin();
		DrinksEntity drinksEntity=new DrinksEntity();
		drinksEntity.setId(5);
		drinksEntity.setName("MixedJuice");
		drinksEntity.setType("MixedfruitsJuice");
		drinksEntity.setColour("undefined");
		entityManager.persist(drinksEntity);
		entityTransaction.commit();
		System.out.println("try block is running");
	}catch(PersistenceException exception) {
		if(entityTransaction.isActive()) {
			entityTransaction.rollback();
			System.out.println("catch block is running");
		}
	}finally {
		entityManager.close();
		entityManagerFactory.close();
		System.out.println("finally block is riuiing");
	}
}
}
