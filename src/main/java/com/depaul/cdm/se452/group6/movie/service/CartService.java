package com.depaul.cdm.se452.group6.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.depaul.cdm.se452.group6.movie.entity.Cart;
import com.depaul.cdm.se452.group6.movie.finder.CartRepository;

@Service
public class CartService {
	private CartRepository cartRepository;
	
	public CartService(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
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
			, List<Long> ticketId
			, List<Long> foodId
			, List<Long> drinkId
			, List<Long> alcoholId
			, Double totalPrice) {
		Cart cart = new Cart();
		cart.setUserId(userId);
		cart.setTicketCart(ticketId);
		cart.setFoodCart(foodId);
		cart.setDrinkCart(drinkId);
		cart.setAlcoholCart(alcoholId);
		cart.setTotalPrice(totalPrice);
		cartRepository.save(cart);
		
		return cart;
		
	}
}
