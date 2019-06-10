package com.depaul.cdm.se452.group6.movie.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "cart")
public class Cart implements Serializable {
	private Long userId;
	private List<Long> ticketCart;
	private Map<Long,Integer> foodCart = new HashMap<Long,Integer>();
	private Map<Long,Integer> drinkCart = new HashMap<Long,Integer>();
	private Map<Long,Integer> alcoholCart = new HashMap<Long,Integer>();
}
