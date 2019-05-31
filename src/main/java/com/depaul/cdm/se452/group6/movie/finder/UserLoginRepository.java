package com.depaul.cdm.se452.group6.movie.finder;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.depaul.cdm.se452.group6.movie.entity.UserLogin;

public interface UserLoginRepository extends CrudRepository<UserLogin, Long> {
	
	List<UserLogin> findAll();
	
	List<UserLogin> findById (String id);
	
	List<UserLogin> findByUserName (String userName);
	
	List<UserLogin> findByUserId (String userId);

}
