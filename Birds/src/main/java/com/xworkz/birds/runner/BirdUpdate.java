package com.xworkz.birds.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class BirdUpdate {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("com.xworkz");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	System.out.println("this is connected successfully");
	
	try {
	entityTransaction.begin();
	Query query=entityManager.createNamedQuery("updateLocation");
    query.setParameter("locationBy", "Mumbai");
    query.setParameter("locationName", "Bangloor");
    query.executeUpdate();
    entityTransaction.commit();
    System.out.println("updated successfully");
   

	}catch(PersistenceException exception) {
		if(entityTransaction.isActive()) {
			entityTransaction.rollback();
		}
	}finally {
		entityManager.close();
		entityManagerFactory.close();
		System.out.println("connection is closed");
	}
}
}

