package com.depaul.cdm.se452.group6.movie.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.depaul.cdm.se452.group6.movie.entity.Cart;
import com.depaul.cdm.se452.group6.movie.finder.CartRepository;

@Service
public class CartService {
	private CartRepository cartRepository;
	private MongoTemplate mongoTemplate;
	
	public CartService(CartRepository cartRepository
			, MongoOperations template) {
		this.cartRepository = cartRepository;
		this.mongoTemplate = mongoTemplate;
	}
	
	public List<Cart> getAll() {
		return cartRepository.findAll();
	}
	
	public List<Cart> getCartByUserId(Long userId) {
		return cartRepository.findByUserId(userId);
	}

	public Cart createTicket(Long userId, List<Long> ticketIds) {
		Cart cart = new Cart();
		cart.setTicketCart(ticketIds);
		cart.setUserId(userId);
		cartRepository.save(cart);

		return cart;
	}
		
	public Cart cartSuccess(Long userId
			, List<Long> ticketIds
			, Map<Long,Integer> foodIds
			, Map<Long,Integer> drinkIds
			, Map<Long,Integer> alcoholIds) {
		Cart cart = new Cart();
		cart.setUserId(userId);
		cart.setTicketCart(ticketIds);
		cart.setFoodCart(foodIds);
		cart.setDrinkCart(drinkIds);
		cart.setAlcoholCart(alcoholIds);
		cartRepository.save(cart);

		return cart;
		
	}
}
