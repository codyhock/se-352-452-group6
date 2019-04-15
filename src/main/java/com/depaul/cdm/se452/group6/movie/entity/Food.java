package com.depaul.cdm.se452.group6.movie.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Food implements Serializable {
	  @Id 		
	  @GeneratedValue
	  private Long id;
	  
	  private String item;
	  
	  private String size;
	  
	  private Double price;
	  
}

