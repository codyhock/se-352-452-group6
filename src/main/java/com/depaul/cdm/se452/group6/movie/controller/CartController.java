package com.depaul.cdm.se452.group6.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.depaul.cdm.se452.group6.movie.service.CartService;

@Controller
public class CartController {
	private CartService cartService;
	
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}
	
	@GetMapping("/cart")
	public String showCart(Long userId, Model model) {
		model.addAttribute("cart",cartService.getCartByUserId(userId));
		return "cart";
	}

}
