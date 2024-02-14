package com.xworkz.restaurant.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.xwork.restaurant.entity.RestaurantEntity;

public class RestaurantRunner2 {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		System.out.println("this is connected");
		try {
			entityTransaction.begin();
			RestaurantEntity restaurantEntity=new RestaurantEntity();
			restaurantEntity.setId(4);
			restaurantEntity.setName("StarFood");
			restaurantEntity.setLocation("Tirupati");
			restaurantEntity.setFood_item("Biriyani");
			entityManager.persist(restaurantEntity);
			entityTransaction.commit();
			System.out.println("Try block is runing");
		}catch(PersistenceException exception) {
			if(entityTransaction.isActive()) {
				entityTransaction.rollback();
				System.out.println("Catch block is active");
			}
		}finally {
			entityManager.close();
			entityManagerFactory.close();
		}
	}

}
