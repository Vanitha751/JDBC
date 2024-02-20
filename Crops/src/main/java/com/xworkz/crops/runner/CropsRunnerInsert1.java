package com.xworkz.crops.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.xworkz.crops.entity.CropsEntity;

public class CropsRunnerInsert1 {
public static void main(String[] args) {

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("com.xworkz");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	System.out.println("this is connected successfully");
	
	try {
		entityTransaction.begin();
		CropsEntity entity=new CropsEntity();
		entity.setId(2);
		entity.setCropName("Ragi");
		entity.setLocation("Goa");
		entity.setPrice(300);
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
