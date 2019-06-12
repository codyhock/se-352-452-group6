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
	
	public List<Drink> getAllDrinks(Long userId) {
		try {
			List<Drink> listOfFood = drinkRepository.findAll();
			logService.logSuccess(userId, "getDrink");
			return listOfFood;
		} catch (Exception e) {
			logService.logError(userId, "getDrink");
			return null;
		}
	}
	
	public List<Drink> getDrinkByItem(String item, Long userId) {
		try {
			List<Drink> listOfFood = drinkRepository.findByItem(item);
			logService.logSuccess(userId, "getDrinkByItem " + item);
			return listOfFood;
		} catch (Exception e) {
			logService.logError(userId, "getDrinkByItem " + item);
			return null;
		}
	}

	public List<Drink> getDrinkByItemAndSize(String item, String size, Long userId) {
		try {
			List<Drink> listOfFood = drinkRepository.findByItem(item);
			logService.logSuccess(userId, "getDrinkByItemAndSize " + item + ", " + size);
			return listOfFood;
		} catch (Exception e) {
			logService.logError(userId, "getDrinkByItemAndSize " + item + ", " + size);
			return null;
		}
	}
	
	public Drink getDrinkById(long id, Long userId) {
		try {
			Drink drink = drinkRepository.findById(id);
			logService.logSuccess(userId, "getDrinkByDrinkId " + id);
			return drink;
		} catch (Exception e) {
			logService.logError(userId, "getDrinkByDrinkId " + id);
			return null;
		}
	}

}
