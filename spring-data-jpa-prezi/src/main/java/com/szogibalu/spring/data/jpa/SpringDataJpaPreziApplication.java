package com.szogibalu.spring.data.jpa;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.szogibalu.spring.data.jpa.entities.User;
import com.szogibalu.spring.data.jpa.repositories.UserRepository;

@SpringBootApplication
public class SpringDataJpaPreziApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringDataJpaPreziApplication.class);

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaPreziApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("Activating all users...");
		userRepository.activateUsers();

		loadUsers();
	}

	private void loadUsers() {
		List<User> users = newArrayList(userRepository.findAll());
		LOGGER.info("Load all users [{}]", users.size());
		users.forEach(user -> LOGGER.info("{}", user));
	}
}
