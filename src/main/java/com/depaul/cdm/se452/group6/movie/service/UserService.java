package com.depaul.cdm.se452.group6.movie.service;

import com.depaul.cdm.se452.group6.movie.entity.User;
import com.depaul.cdm.se452.group6.movie.finder.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
	
	 private UserRepository userRepository;
	 private LogService logService;
	 
	 public UserService(UserRepository userRepository,
			 			LogService logService) {
		 this.userRepository = userRepository;
		 this.logService = logService;
	 }
	 
	 public List<User> getUsers() {
		 try {
			 List<User> users = userRepository.findAll();
			 logService.logSuccess("test_user", "getAllUsers");
		     return users;
		 }	 catch (Exception e) {
			 logService.logError("test_user", "getAllUsers");
		     return null;
		     }
	}
	 
	 public List<User> findUsersByFirstname(String firstname) {
		 try {
			 List<User> users = userRepository.findByFirstname(firstname);
			 logService.logSuccess("test_user", "findByFirstname " + firstname);
			 return users;
		 }   catch (Exception e) {
		     logService.logError("test_user", "findByFirstname " + firstname);
		     return null;
		     }
	 }
	 
	 public List<User> findUsersByLastname(String lastname) {
		 try {
			 List<User> users = userRepository.findByLastname(lastname);
			 logService.logSuccess("test_user", "findByLastname " + lastname);
			 return users;
		 }   catch (Exception e) {
		     logService.logError("test_user", "findByLastname " + lastname);
		     return null;
		     }
	 }
	 
	 public User findByUserId(long id) {
		 try {
			 User users = userRepository.findById(id);
			 logService.logSuccess("test_user", "findByUserId " + id);
			 return users;
		 }   catch (Exception e) {
		     logService.logError("test_user", "findByUserId " + id);
		     return null;
		     }
	 }
	 
}


