package com.depaul.cdm.se452.group6.movie.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Item {
	
	private Food food; 
//	private Drink drink; 
//	private AlcoholItem alcohol; 
	
	@NotNull
	@Min(0)
	private int foodQuantity;
	
//	@NotNull
//	@Min(0)
//	private int drinkQuantity;
//	
//	@NotNull
//	@Min(0)
//	private int alcoholQuantity;

}
