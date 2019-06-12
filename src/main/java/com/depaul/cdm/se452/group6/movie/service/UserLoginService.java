package com.depaul.cdm.se452.group6.movie.service;

import java.util.List;

import com.depaul.cdm.se452.group6.movie.config.LogConfig;
import com.depaul.cdm.se452.group6.movie.config.LogLevel;
import org.springframework.stereotype.Service;

import com.depaul.cdm.se452.group6.movie.entity.UserLogin;
import com.depaul.cdm.se452.group6.movie.finder.UserLoginRepository;

@Service
public class UserLoginService {
	
	private UserLoginRepository userloginRepository;
	private LogConfig logConfig;

	public UserLoginService(UserLoginRepository userloginRepository, LogConfig logConfig) {
		   this.userloginRepository = userloginRepository;
		   this.logConfig = logConfig;
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

	public void registerUser(UserLogin userLogin) {
        userloginRepository.save(userLogin);
	}

}
