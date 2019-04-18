package com.depaul.cdm.se452.group6.movie.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User implements Serializable {
	  @Id
	  @GeneratedValue
	  @Column(name = "userid")
	  private Long id;

	  private String firstname;
	  
	  private String lastname;
	  
	  private String email;
	  
	  private String username;
	  
	  private String password;
	  
	  
	 @ManyToOne
	 @JoinColumn(name = "usertypeid", nullable = false)
	 private UserType usertype;
}
