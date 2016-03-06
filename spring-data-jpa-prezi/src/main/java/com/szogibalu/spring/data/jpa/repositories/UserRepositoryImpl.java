package com.szogibalu.spring.data.jpa.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.szogibalu.spring.data.jpa.entities.Status;
import com.szogibalu.spring.data.jpa.entities.User;

@Transactional
public class UserRepositoryImpl implements UserRepositoryHelper {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void activateUsers() {
		List<User> users = entityManager.createQuery("FROM com.szogibalu.spring.data.jpa.entities.User", User.class)
				.getResultList();
		users.forEach(user -> {
			user.setStatus(Status.ACTIVE);
			entityManager.persist(user);
		});
	}

}
