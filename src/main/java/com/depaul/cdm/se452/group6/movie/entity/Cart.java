package com.depaul.cdm.se452.group6.movie.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "cart")
public class Cart implements Serializable {
	private Long userId;
	private List<Long> ticketCart;
	private List<Long> foodCart;
	private List<Long> drinkCart; 
	private List<Long> alcoholCart;
	private Double totalPrice;

}
