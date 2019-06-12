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
	 
	 public List<User> getUsers(Long userId) {
		 try {
			 List<User> users = userRepository.findAll();
			 logService.logSuccess(userId, "getAllUsers");
		     return users;
		 }	 catch (Exception e) {
			 logService.logError(userId, "getAllUsers");
		     return null;
		     }
	}
	 
	 public List<User> findUsersByFirstname(String firstname, Long userId) {
		 try {
			 List<User> users = userRepository.findByFirstname(firstname);
			 logService.logSuccess(userId, "findByFirstname " + firstname);
			 return users;
		 }   catch (Exception e) {
		     logService.logError(userId, "findByFirstname " + firstname);
		     return null;
		     }
	 }
	 
	 public List<User> findUsersByLastname(String lastname, Long userId) {
		 try {
			 List<User> users = userRepository.findByLastname(lastname);
			 logService.logSuccess(userId, "findByLastname " + lastname);
			 return users;
		 }   catch (Exception e) {
		     logService.logError(userId, "findByLastname " + lastname);
		     return null;
		     }
	 }
	 
	 public User findByUserId(long id, Long userId) {
		 try {
			 User users = userRepository.findById(id);
			 logService.logSuccess(userId, "findByUserId " + id);
			 return users;
		 }   catch (Exception e) {
		     logService.logError(userId, "findByUserId " + id);
		     return null;
		     }
	 }
	 
}


