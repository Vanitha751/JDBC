package com.xworkz.drinks.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.xworkz.drinks.entity.DrinksEntity;

public class DrinkRunnerUpdate2 {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("com.xworkz");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	System.out.println("This is connected");
	
	try {
		entityTransaction.begin();	
	    DrinksEntity entity=entityManager.find(DrinksEntity.class, 3);
	    entity.setColour("Brownish");
	    entityManager.merge(entity);
	    entityTransaction.commit();
	    System.out.println("value is updated");
	}catch(PersistenceException e) {
		if(entityTransaction.isActive()) {
			entityTransaction.rollback();
		}
	}finally {
	 entityManager.close();
	 entityManagerFactory.close();
	}
}
}     