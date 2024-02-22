package com.xwokz.ipl.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.xwokz.ipl.entity.IplEntity;


public class IplRunner {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		System.out.println("this is connected successfully");
		
		try {
			entityTransaction.begin();
			IplEntity entity=new IplEntity(1,"Potugallu",11,"Kohli","ShivaPrakash","Green");
			IplEntity entity1=new IplEntity(2,"Thagedele",11,"Virat","Shiva","Blue");
			IplEntity entity2=new IplEntity(3,"India",11,"Dhoni","raj","Red");
			IplEntity entity3=new IplEntity(4,"Autralia",11,"DhruvChand","Yasashwi","White");
			IplEntity entity4=new IplEntity(5,"Pakisthan",11,"AkashDeep","Harish","SkyBlue");

			entityManager.persist(entity);
			entityManager.persist(entity1);
			entityManager.persist(entity2);
			entityManager.persist(entity3);
			entityManager.persist(entity4);

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
