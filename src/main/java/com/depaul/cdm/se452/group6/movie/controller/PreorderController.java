package com.depaul.cdm.se452.group6.movie.controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.validation.Valid;

import com.depaul.cdm.se452.group6.movie.model.PreOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    public String showMenu(Model model, @SessionAttribute(name="userID") Long userID) {
    	model.addAttribute("food", foodService.getAllFood(userID));
    	model.addAttribute("drinks", drinkService.getAllDrinks(userID));
    	model.addAttribute("alcohol", alcoholService.getAllAlcohol(userID));
        return "preorderMenu";
    }
    
	@GetMapping("/form")
    public String showForm(Model model, @SessionAttribute(name="userID") Long userID) {
    	model.addAttribute("listOfFood", foodService.getAllFood(userID));
    	model.addAttribute("listOfDrinks", drinkService.getAllDrinks(userID));
    	model.addAttribute("listOfAlcohol", alcoholService.getAllAlcohol(userID));
    	//model.addAttribute("cart", new Cart());
			//model.addAttribute("cart", cartService.getCartByUserId(userID).get(0));
			model.addAttribute("cart", new PreOrder());
    	return "preorderForm";
    }
	
	@PostMapping("/form")
	public String saveForm(@Valid @ModelAttribute("cart") PreOrder cart, BindingResult result,
												 @SessionAttribute(name="userID") Long userID) {

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

		Cart currentCart = cartService.getCartByUserId(userID).get(0);
		currentCart.setFoodCart(cart.getFoodCart());
		currentCart.setDrinkCart(cart.getDrinkCart());
		currentCart.setAlcoholCart(cart.getAlcoholCart());
		cartService.cartSuccess(currentCart);

		return "redirect:/cart";
	}
	
}
