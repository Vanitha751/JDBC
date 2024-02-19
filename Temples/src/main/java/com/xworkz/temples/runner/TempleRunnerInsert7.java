package com.xworkz.temples.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.xworkz.temples.entity.TempleEntity;

public class TempleRunnerInsert7 {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		System.out.println("this is connected");
		
		try {
			entityTransaction.begin();
			TempleEntity entity=new TempleEntity();
			entity.setId(7);
			entity.setName("Tiruvannamalai");
			entity.setLocation("TamilNadu");
			entity.setTicketPrice(500);
			entity.setOfferings(2050);
			entityManager.persist(entity);
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
