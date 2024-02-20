package com.xworkz.crops.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class CropRunnerUpdate1 {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("com.xworkz");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	System.out.println("this is connected successfully");
	
	try {
	entityTransaction.begin();
	Query query=entityManager.createQuery("UPDATE CropsEntity entity SET entity.location=:locationBy where entity.cropName=:cropNameBy");
	
    query.setParameter("locationBy", "Punjab");
    query.setParameter("cropNameBy", "Ragi");
    query.executeUpdate();
    entityTransaction.commit();
    System.out.println("updated successfully");
    //entityManager.createNamedQuery("updateBy");
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
