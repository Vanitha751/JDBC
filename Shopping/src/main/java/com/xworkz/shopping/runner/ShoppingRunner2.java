package com.xworkz.shopping.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.xworkz.shopping.entity.ShoppingEntity;

public class ShoppingRunner2 {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		System.out.println("connected");
		try {
			transaction.begin();
			ShoppingEntity shoppingEntity=new ShoppingEntity();
			shoppingEntity.setId(3);
			shoppingEntity.setShop_name("MGR Mall");
			shoppingEntity.setLocation("GandhiRoad");
			shoppingEntity.setItems("item2");
			entityManager.persist(shoppingEntity);
			transaction.commit();	
		}catch(PersistenceException e){
		 if(transaction.isActive()) {
			 transaction.rollback();
		 }
		}finally {
			entityManager.close();
			entityManagerFactory.close();
		}
	}

}
