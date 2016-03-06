package com.szogibalu.spring.data.jpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.szogibalu.spring.data.jpa.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
