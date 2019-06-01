package com.depaul.cdm.se452.group6.movie.service;

import java.util.List;
import java.util.Optional;

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

	public List<Food> getAllFood() {
		try {
			List<Food> listOfFood = foodRepository.findAll();
			logService.logSuccess("test_user", "getFood");
			return listOfFood;
		} catch (Exception e) {
	        logService.logSuccess("test_user", "getFood");
	        return null;
	    }
	}

	public List<Food> getFoodByItem(String item) {
		try {
			List<Food> listOfFood = foodRepository.findByItem(item);
	        logService.logSuccess("test_user", "getFoodByItem " + item);
	        return listOfFood;
	    } catch (Exception e) {
	        logService.logSuccess("test_user", "getFoodByItem " + item);
	        return null;
	    }

	}

	public List<Food> getFoodByItemAndSize(String item, String size) {
		try {
			List<Food> listOfFood = foodRepository.findByItem(item);
	        logService.logSuccess("test_user", "getFoodByItemAndSize " + item + ", " + size);
	        return listOfFood;
	    } catch (Exception e) {
	        logService.logSuccess("test_user", "getFoodByItemAndSize " + item + ", " + size);
	        return null;
	    }
	}

}
