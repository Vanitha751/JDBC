package com.xworkz.wallet.runner;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.EntityTransaction;
	import javax.persistence.Persistence;
	import javax.persistence.PersistenceException;

	import com.xworkz.wallet.entity.WalletEntity;

	public class WalletRunner {
		public static void main(String[] args) {
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("com.xworkz");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			try {
				entityTransaction.begin();
				WalletEntity entity=new WalletEntity(1, "Company1", 200, "Brown",10);
				WalletEntity entity1 = new WalletEntity(2, "Company2", 30, "Red", 8);
				WalletEntity entity2 = new WalletEntity(3, "Company3", 25, "Green", 12);
				WalletEntity entity3 = new WalletEntity(4, "Company4", 15, "Yellow", 9);
				WalletEntity entity4 = new WalletEntity(5, "Company5", 35, "SkyBlue", 14);
				entityManager.persist(entity);
				entityManager.persist(entity1);
				entityManager.persist(entity2);
				entityManager.persist(entity3);
				entityManager.persist(entity4);
	            entityTransaction.commit();
			}catch(PersistenceException e) {
				if(entityTransaction.isActive()) {
					entityTransaction.commit();
				}
			}finally {
				entityManager.close();
				entityManagerFactory.close();
				System.out.println("closed");
			}
		}

}
