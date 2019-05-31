package com.depaul.cdm.se452.group6.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.depaul.cdm.se452.group6.movie.entity.Cart;
import com.depaul.cdm.se452.group6.movie.entity.Food;
import com.depaul.cdm.se452.group6.movie.entity.Item;
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
	
	public Cart cartSuccess(Long userId
			, List<Item> ticketItem
			, List<Item> foodItem
			, List<Item> drinkItem
			, List<Item> alcoholItem
			, Double totalPrice) {
		Cart cart = new Cart();
		cart.setUserId(userId);
		cart.setTicketCart(ticketItem);
		cart.setFoodCart(foodItem);
		cart.setDrinkCart(drinkItem);
		cart.setAlcoholCart(alcoholItem);
		cart.setTotalPrice(totalPrice);
		cartRepository.save(cart);
		
		return cart;
		
	}
}
