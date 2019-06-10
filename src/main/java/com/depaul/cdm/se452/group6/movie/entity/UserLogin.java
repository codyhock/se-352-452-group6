package com.depaul.cdm.se452.group6.movie.entity;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Data 
@Document(collection = "userlogins")
public class UserLogin implements Serializable {
//	@Id
//    @GeneratedValue
//	private Long id;
	
	private Long userId;
	
	private String userName;
	
	private String password;
	
}
