package com.depaul.cdm.se452.group6.movie.finder;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Quantity {
	
	@NotNull
	@Min(value = 0, message = "The value must be positive")
	private int numberOfItems;
}
