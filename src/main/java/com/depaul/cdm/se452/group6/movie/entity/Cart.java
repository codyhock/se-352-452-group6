package com.depaul.cdm.se452.group6.movie.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "cart")
public class Cart implements Serializable {
	private Long userId;

	//private Long ticketId;
	private List<Long> ticketId;

	//private Long foodId;
	private List<Long> foodId;

	//private Long drinkId; // food and the list of number
	private List<Long> drinkId;

	//private Long alcoholId;
	private List<Long> alcoholId;

	//private Long totalPrice;
	private Double totalPrice;
}
