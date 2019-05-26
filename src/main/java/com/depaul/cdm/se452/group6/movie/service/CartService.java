//package com.depaul.cdm.se452.group6.movie.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.stereotype.Service;
//
//import com.depaul.cdm.se452.group6.movie.entity.Cart;
//import com.depaul.cdm.se452.group6.movie.finder.CartRepository;
//
//@Service
//public class CartService {
//	private CartRepository cartRepository;
//	
//	public CartService(CartRepository cartRepository) {
//		this.cartRepository = cartRepository;
//	}
//	
//	public List<Cart> getAll() {
//		return cartRepository.findAll();
//	}
//	
//	public List<Cart> getCartByUserId(Long userId) {
//		return cartRepository.findByUserId(userId);
//	}
//	
////	public Optional<Cart> getCartById(Long id) {
////		return cartRepository.findById(id);
////	}
//	
//	public Cart cartSuccess(Long userId, Long ticketId
//			,Long foodId, Long drinkId
//			,Long alcoholId, Double totalPrice) {
//		Cart cart = new Cart();
//		cart.setUserId(userId);
//		cart.setTicketId(ticketId);
//		cart.setFoodId(foodId);
//		cart.setDrinkId(drinkId);
//		cart.setAlcoholId(alcoholId);
//		cart.setTotalPrice(totalPrice);
//		cartRepository.save(cart);
//		
//		return cart;
//		
//	}
//}
