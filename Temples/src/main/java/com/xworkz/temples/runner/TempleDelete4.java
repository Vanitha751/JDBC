package com.xworkz.temples.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.xworkz.temples.entity.TempleEntity;

public class TempleDelete4 {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		System.out.println("Connected successfully");
		
		try {
			entityTransaction.begin();
			TempleEntity entity=entityManager.find(TempleEntity.class,8);
			entityManager.remove(entity);
			entityTransaction.commit();
			System.out.println("deleted successfully");
		}catch(PersistenceException e) {
			if(entityTransaction.isActive()) {
			entityTransaction.rollback();	
			}
		}finally {
			entityManager.close();
			entityManagerFactory.close();
			System.out.println("connection is closed successfully");
}
}}
