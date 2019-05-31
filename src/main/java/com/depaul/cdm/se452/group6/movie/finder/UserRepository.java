package com.depaul.cdm.se452.group6.movie.finder;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.depaul.cdm.se452.group6.movie.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	List<User> findAll();
	
	List<User> findByFirstname(String firstname);
	
	List<User> findByLastname(String lastname);
}
