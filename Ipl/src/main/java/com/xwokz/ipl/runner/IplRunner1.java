package com.xwokz.ipl.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class IplRunner1 {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("com.xworkz");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	System.out.println("Connected successfully");
	
	try {
		entityTransaction.begin();
		Query query=entityManager.createNamedQuery("findTeamName");
		query.setParameter("nameBy", "kohli");
		
		Object obj=query.getSingleResult();
		String name=(String)obj;
		
		System.out.println("The class is:"+name);
		
		entityTransaction.commit();
	}catch(PersistenceException exception) {
		if(entityTransaction.isActive()) {
			entityTransaction.rollback();
		}
	}finally{
		entityManager.close();
		entityManagerFactory.close();
		System.out.println("connection is closed");
	}
}
}
