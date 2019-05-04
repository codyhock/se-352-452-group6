package com.depaul.cdm.se452.group6.movie.entity;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "food")
public class Food implements Serializable {
	  @Id 		
	  @GeneratedValue
	  private Long id;
	  
	  private String item;
	  
	  private String size;
	  
	  private Double price;
	  
}

