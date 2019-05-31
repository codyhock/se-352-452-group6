package com.depaul.cdm.se452.group6.movie.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "cart")
public class Cart implements Serializable {
	private Long userId;
	private List<Item> ticketCart;
	private List<Item> foodCart;
	private List<Item> drinkCart; 
	private List<Item> alcoholCart;
	private Double totalPrice;

}
