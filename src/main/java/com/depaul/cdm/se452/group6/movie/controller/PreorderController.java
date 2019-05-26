package com.depaul.cdm.se452.group6.movie.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.depaul.cdm.se452.group6.movie.entity.Item;
import com.depaul.cdm.se452.group6.movie.service.AlcoholService;
import com.depaul.cdm.se452.group6.movie.service.DrinkService;
import com.depaul.cdm.se452.group6.movie.service.FoodService;

@Controller
public class PreorderController implements WebMvcConfigurer {
	private FoodService foodService;
	private DrinkService drinkService;
	private AlcoholService alcoholService;

	public PreorderController(FoodService foodService
			, DrinkService drinkService
			, AlcoholService alcoholService) {
		this.foodService = foodService;
		this.drinkService = drinkService;
		this.alcoholService = alcoholService;
	}

    @GetMapping("/preorder-snacks-beverage/menu")
    public String showMenu(Model model) {
    	model.addAttribute("food", foodService.getAllFood());
    	model.addAttribute("drinks", drinkService.getAllDrinks());
    	model.addAttribute("alcohol", alcoholService.getAllAlcohol());
        return "preorderMenu";
    }
    
    @GetMapping("/preorder-snacks-beverage/form")
    public String showForm(Model model, Item item) {
    	model.addAttribute("food", foodService.getAllFood());
    	model.addAttribute("drinks", drinkService.getAllDrinks());
    	model.addAttribute("alcohol", alcoholService.getAllAlcohol());
        return "preorderForm";
    }
    
    @PostMapping("/preorder-snacks-beverage/form")
    public String checkQuantity(@Valid Item item, BindingResult bindingResult) {
        
    	if (bindingResult.hasErrors()) {
        	return "redirect:/preorder-snacks-beverage/form";
        } 
    	
        return "cart";
    }

}
