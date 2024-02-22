package com.xwokz.ipl.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class IplRunner3 {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("com.xworkz");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	System.out.println("Connected successfully");
	
	try {
		entityTransaction.begin();
		Query query=entityManager.createNamedQuery("findTeamNameAndcolour");
		query.setParameter("entityBy","Thagedele");
		
		Object[] object=(Object[]) query.getSingleResult();
		String name=(String)object[0];
		String colour=(String)object[1];
		
		System.out.println("The class is:"+name);
		System.out.println("The classs is:"+colour);
		
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
