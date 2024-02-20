package com.xworkz.birds.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.xworkz.birds.entity.BirdsEntity;


public class BirdsRunnerInsert {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("com.xworkz");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	System.out.println("this is connected successfully");
	
	try {
		entityTransaction.begin();
		BirdsEntity entity=new BirdsEntity();
		entity.setId(4);
		entity.setName("Penguvin");
		entity.setLocation("Polar");
		entity.setAge(200);
		entityManager.persist(entity);
		entityTransaction.commit();
	}catch(PersistenceException exception) {
		if(entityTransaction.isActive()) {
			entityTransaction.rollback();
			System.out.println("catch block is running");
		}
	}finally {
		entityManager.close();
		entityManagerFactory.close();
		System.out.println("connection is closed successfully");
	}

}
}
