package com.depaul.cdm.se452.group6.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.depaul.cdm.se452.group6.movie.entity.AlcoholItem;
import com.depaul.cdm.se452.group6.movie.finder.AlcoholItemRepository;

@Service
public class AlcoholService {
	private AlcoholItemRepository alcoholRepository;
	private LogService logService;
	
	public AlcoholService(AlcoholItemRepository alcoholRepository, LogService logService) {
		this.alcoholRepository = alcoholRepository;
		this.logService = logService;
	}
	
	public List<AlcoholItem> getAllAlcohol() { 
		try {
			List<AlcoholItem> listOfFood = alcoholRepository.findAll();
			logService.logSuccess("test_user", "getAlcohol");
			return listOfFood;
		} catch (Exception e) {
			logService.logError("test_user", "getAlcohol");
			return null;
		}
	}
	
	public List<AlcoholItem> getAlcoholByType(String type) {
		try {
			List<AlcoholItem> listOfFood = alcoholRepository.findByType(type);
			logService.logSuccess("test_user", "getAlcoholByType " + type);
			return listOfFood;
		} catch (Exception e) {
			logService.logError("test_user", "getAlcoholByType " + type);
			return null;
		}
	}

	public List<AlcoholItem> getAlcoholByPrice(Double price) {
		try {
			List<AlcoholItem> listOfFood = alcoholRepository.findByPrice(price);
			logService.logSuccess("test_user", "getAlcoholByPrice " + price);
			return listOfFood;
		} catch (Exception e) {
			logService.logError("test_user", "getAlcoholByPrice " + price);
			return null;
		}
	}
	
	public AlcoholItem getAlcoholById(long id) {
		try {
			AlcoholItem alcoholItem = alcoholRepository.findById(id);
			logService.logSuccess("test_user", "getAlcoholItemByAlcoholId " + id);
			return alcoholItem;
		} catch (Exception e) {
			logService.logError("test_user", "getAlcoholByAlcoholId " + id);
			return null;
		}
	}
}
