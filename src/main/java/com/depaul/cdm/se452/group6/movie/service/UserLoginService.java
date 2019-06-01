package com.depaul.cdm.se452.group6.movie.service;

import java.util.List;

import com.depaul.cdm.se452.group6.movie.entity.UserLogin;
import com.depaul.cdm.se452.group6.movie.finder.UserLoginRepository;

public class UserLoginService {
	
	private UserLoginRepository userloginRepository;
	private LogService logService;
	
	public UserLoginService(UserLoginRepository userloginRepository,
					        LogService logService) {
		   this.userloginRepository = userloginRepository;
		   this.logService = logService;
	}
	
	public List<UserLogin> getUserLogins() {
		 try {
			 List<UserLogin> userlogins = userloginRepository.findAll();
			 logService.logSuccess("test_user", "getAllUserLogins");
		     return userlogins;
		 }	 catch (Exception e) {
			 logService.logError("test_user", "getAllUserLogins");
		     return null;
		     }
	}
	
	public List<UserLogin> findByUserLoginId(String id) {
		 try {
			 List<UserLogin> userlogins = userloginRepository.findById(id);
			 logService.logSuccess("test_user", "findById " + id);
			 return userlogins;
		 }   catch (Exception e) {
		     logService.logError("test_user", "findById " + id);
		     return null;
		     }
	 }
	
	public List<UserLogin> findByUserLoginName(String userName) {
		 try {
			 List<UserLogin> userlogins = userloginRepository.findByUserName(userName);
			 logService.logSuccess("test_user", "findByUserName " + userName);
			 return userlogins;
		 }   catch (Exception e) {
		     logService.logError("test_user", "findByUserName " + userName);
		     return null;
		     }
	 }
	
	public List<UserLogin> findByUserId(String userId) {
		 try {
			 List<UserLogin> userlogins = userloginRepository.findByUserId(userId);
			 logService.logSuccess("test_user", "findByUserId " + userId);
			 return userlogins;
		 }   catch (Exception e) {
		     logService.logError("test_user", "findByUserId " + userId);
		     return null;
		     }
	 }

}
