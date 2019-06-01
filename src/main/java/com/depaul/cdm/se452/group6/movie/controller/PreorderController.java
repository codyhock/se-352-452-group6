package com.depaul.cdm.se452.group6.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.depaul.cdm.se452.group6.movie.entity.Cart;
import com.depaul.cdm.se452.group6.movie.entity.Food;
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

	public PreorderController(FoodService foodService
			, DrinkService drinkService
			, AlcoholService alcoholService
			, CartService cartService) {
		this.foodService = foodService;
		this.drinkService = drinkService;
		this.alcoholService = alcoholService;
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
        return "preorderForm";
    }	
	
}
