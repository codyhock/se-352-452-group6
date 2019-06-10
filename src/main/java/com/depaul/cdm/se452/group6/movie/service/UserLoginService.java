package com.depaul.cdm.se452.group6.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.depaul.cdm.se452.group6.movie.entity.UserLogin;
import com.depaul.cdm.se452.group6.movie.finder.UserLoginRepository;

@Service
public class UserLoginService {
	
	private UserLoginRepository userloginRepository;
	
	public UserLoginService(UserLoginRepository userloginRepository) {
		   this.userloginRepository = userloginRepository;
	}
	
	public List<UserLogin> getUserLogins() {
		List<UserLogin> userlogins = userloginRepository.findAll();
		return userlogins;		
	}
	
	public List<UserLogin> findByUserLoginName(String userName) {
		List<UserLogin> userlogins = userloginRepository.findByUserName(userName);
		return userlogins;
	 }
	
	// made a change from list<UserLogin> to UserLogin
	public UserLogin findByUserId(Long userId) {
		UserLogin userlogins = userloginRepository.findByUserId(userId);
		return userlogins;

	 }
	
	public UserLogin loginSuccess(Long userId, String userName, String password) {
		UserLogin userLogin = new UserLogin();
		userLogin.setUserId(userId);
		userLogin.setUserName(userName);
		userLogin.setPassword(password);
		userloginRepository.save(userLogin);
		
		return userLogin;
	}

}
