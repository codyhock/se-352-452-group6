package com.depaul.cdm.se452.group6.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.depaul.cdm.se452.group6.movie.entity.Drink;
import com.depaul.cdm.se452.group6.movie.finder.DrinkRepository;

@Service
public class DrinkService {
	private DrinkRepository drinkRepository;
	private LogService logService;
	
	public DrinkService(DrinkRepository drinkRepository, LogService logService) {
		this.drinkRepository = drinkRepository;
		this.logService = logService;
	}
	
	public List<Drink> getAllDrinks() {
		try {
			List<Drink> listOfFood = drinkRepository.findAll();
			logService.logSuccess("test_user", "getDrink");
			return listOfFood;
		} catch (Exception e) {
			logService.logError("test_user", "getDrink");
			return null;
		}
	}
	
	public List<Drink> getDrinkByItem(String item) {
		try {
			List<Drink> listOfFood = drinkRepository.findByItem(item);
			logService.logSuccess("test_user", "getDrinkByItem " + item);
			return listOfFood;
		} catch (Exception e) {
			logService.logError("test_user", "getDrinkByItem " + item);
			return null;
		}
	}

	public List<Drink> getDrinkByItemAndSize(String item, String size) {
		try {
			List<Drink> listOfFood = drinkRepository.findByItem(item);
			logService.logSuccess("test_user", "getDrinkByItemAndSize " + item + ", " + size);
			return listOfFood;
		} catch (Exception e) {
			logService.logError("test_user", "getDrinkByItemAndSize " + item + ", " + size);
			return null;
		}
	}

}
