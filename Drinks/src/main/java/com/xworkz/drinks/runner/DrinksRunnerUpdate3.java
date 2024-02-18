package com.xworkz.drinks.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.xworkz.drinks.entity.DrinksEntity;

public class DrinksRunnerUpdate3 {

	public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("com.xworkz");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction=entityManager.getTransaction();
    System.out.println("cpnnected successfully");
    try {
    			entityTransaction.begin();
    	    	DrinksEntity entity=entityManager.find(DrinksEntity.class, 4);
    	    	entity.setType("good");
    	    	entityManager.merge(entity);
    	    	entityTransaction.commit();
                System.out.println("updated successfully");        
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
