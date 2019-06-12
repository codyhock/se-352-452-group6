package com.depaul.cdm.se452.group6.movie.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User implements Serializable {
	  @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "userid")
	  private Long id;

	  private String firstname;
	  
	  private String lastname;
	  
	  private String email;

	  private LocalDate dateofbirth;
	  
	  private String phonenumber;
	  
	 @ManyToOne
	 @JoinColumn(name = "usertypeid", nullable = false)
	 private UserType usertype;
}
