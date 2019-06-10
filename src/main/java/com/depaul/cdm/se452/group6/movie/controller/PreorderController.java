package com.depaul.cdm.se452.group6.movie.controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.depaul.cdm.se452.group6.movie.entity.Cart;
import com.depaul.cdm.se452.group6.movie.service.AlcoholService;
import com.depaul.cdm.se452.group6.movie.service.CartService;
import com.depaul.cdm.se452.group6.movie.service.DrinkService;
import com.depaul.cdm.se452.group6.movie.service.FoodService;

@Controller
@RequestMapping("/preorder")
public class PreorderController implements WebMvcConfigurer {
	private FoodService foodService;
	private DrinkService drinkService;
	private AlcoholService alcoholService;
	private CartService cartService;

	public PreorderController(FoodService foodService
			, DrinkService drinkService
			, AlcoholService alcoholService
			, CartService cartService) {
		this.foodService = foodService;
		this.drinkService = drinkService;
		this.alcoholService = alcoholService;
		this.cartService = cartService;
	}

	@GetMapping("/menu")
    public String showMenu(Model model) {
    	model.addAttribute("food", foodService.getAllFood());
    	model.addAttribute("drinks", drinkService.getAllDrinks());
    	model.addAttribute("alcohol", alcoholService.getAllAlcohol());
        return "preorderMenu";
    }
    
	@GetMapping("/form")
    public String showForm(Model model) {
    	model.addAttribute("listOfFood", foodService.getAllFood());
    	model.addAttribute("listOfDrinks", drinkService.getAllDrinks());
    	model.addAttribute("listOfAlcohol", alcoholService.getAllAlcohol());
    	model.addAttribute("cart", new Cart());
    	return "preorderForm";
    }
	
	@PostMapping("/form")
	public String saveForm(@Valid @ModelAttribute("cart") Cart cart, BindingResult result) {
	    if (result.hasErrors()) {
	        return "redirect:/preorder/form";
	    }
		
		Iterator<Integer> iterateFood = cart.getFoodCart().values().iterator();
		while(iterateFood.hasNext()) {
			Integer tmp = iterateFood.next();
			if (tmp.equals(0)) {
				iterateFood.remove();
			}
		}
		
		Iterator<Integer> iterateDrink = cart.getDrinkCart().values().iterator();
		while(iterateDrink.hasNext()) {
			Integer tmp = iterateDrink.next();
			if (tmp.equals(0)) {
				iterateDrink.remove();
			}
		}
		
		Iterator<Integer> iterateAlcohol = cart.getAlcoholCart().values().iterator();
		while(iterateAlcohol.hasNext()) {
			Integer tmp = iterateAlcohol.next();
			if (tmp.equals(0)) {
				iterateAlcohol.remove();
			}
		} 
		
//		cartService.cartSuccess(1L, cartService.getCartByUserId(1L).get(0).getTicketCart()
//				, cart.getFoodCart(), cart.getDrinkCart(), cart.getAlcoholCart());
		cartService.cartSuccess(1L, new ArrayList<Long>()
				, cart.getFoodCart(), cart.getDrinkCart(), cart.getAlcoholCart());
		

		return "redirect:/cart";
	}
	
}
