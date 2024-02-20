package com.xworkz.birds.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class BirdsUpdate3 {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("com.xworkz");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	System.out.println("this is connected successfully");
	
	try {
	entityTransaction.begin();
	Query query=entityManager.createQuery("UPDATE BirdsEntity entity SET entity.location=:locationBy where entity.name=:birdNameBy");
	
    query.setParameter("locationBy", "Daminedu");
    query.setParameter("birdNameBy", "Crow");
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

