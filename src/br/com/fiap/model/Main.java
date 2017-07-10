package br.com.fiap.model;

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String [] args) {
		
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("system");
		
		EntityManager em = emf.createEntityManager();
		
		User user = new User();
		user.setName("Teste");
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
		
		Cache cache = emf.getCache();
		System.out.println("Usuário "+ user.getName() + " está em Cache? " + cache.contains(User.class, user.getId()));
	}
	
}