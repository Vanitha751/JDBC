package com.xworkz.temples.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.xworkz.temples.entity.TempleEntity;

public class TempleRunnerInsert6 {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		System.out.println("this is connected");
		
		try {
			entityTransaction.begin();
			TempleEntity entity=new TempleEntity();
			entity.setId(6);
			entity.setName("siridi");
			entity.setLocation("siridi");
			entity.setTicketPrice(5000);
			entity.setOfferings(2500);
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
