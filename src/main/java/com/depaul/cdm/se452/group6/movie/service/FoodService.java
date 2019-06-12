package com.depaul.cdm.se452.group6.movie.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.depaul.cdm.se452.group6.movie.entity.Food;
import com.depaul.cdm.se452.group6.movie.finder.FoodRepository;

@Service
public class FoodService {
	private FoodRepository foodRepository;
	private LogService logService;

	public FoodService(FoodRepository foodRepository, LogService logService) {
		this.foodRepository = foodRepository;
		this.logService = logService;
	}

	public List<Food> getAllFood(Long userId) {
		try {
			List<Food> listOfFood = foodRepository.findAll();
			logService.logSuccess(userId, "getFood");
			return listOfFood;
		} catch (Exception e) {
			logService.logError(userId, "getFood");
			return null;
		}
	}

	public List<Food> getFoodByItem(String item, Long userId) {
		try {
			List<Food> listOfFood = foodRepository.findByItem(item);
			logService.logSuccess(userId, "getFoodByItem " + item);
			return listOfFood;
		} catch (Exception e) {
			logService.logError(userId, "getFoodByItem " + item);
			return null;
		}
	}

	public List<Food> getFoodByItemAndSize(String item, String size, Long userId) {
		try {
			List<Food> listOfFood = foodRepository.findByItem(item);
			logService.logSuccess(userId, "getFoodByItemAndSize " + item + ", " + size);
			return listOfFood;
		} catch (Exception e) {
			logService.logError(userId, "getFoodByItemAndSize " + item + ", " + size);
			return null;
		}
	}
	
	public Food getFoodById(long id, Long userId) {
		try {
			Food food = foodRepository.findById(id);
			logService.logSuccess(userId, "getFoodByFoodId " + id);
			return food;
		} catch (Exception e) {
			logService.logError(userId, "getFoodByFoodId " + id);
			return null;
		}
	}

}
