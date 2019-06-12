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
	
	public List<AlcoholItem> getAllAlcohol(Long userId) {
		try {
			List<AlcoholItem> listOfFood = alcoholRepository.findAll();
			logService.logSuccess(userId, "getAlcohol");
			return listOfFood;
		} catch (Exception e) {
			logService.logError(userId, "getAlcohol");
			return null;
		}
	}
	
	public List<AlcoholItem> getAlcoholByType(String type, Long userId) {
		try {
			List<AlcoholItem> listOfFood = alcoholRepository.findByType(type);
			logService.logSuccess(userId, "getAlcoholByType " + type);
			return listOfFood;
		} catch (Exception e) {
			logService.logError(userId, "getAlcoholByType " + type);
			return null;
		}
	}

	public List<AlcoholItem> getAlcoholByPrice(Double price, Long userId) {
		try {
			List<AlcoholItem> listOfFood = alcoholRepository.findByPrice(price);
			logService.logSuccess(userId, "getAlcoholByPrice " + price);
			return listOfFood;
		} catch (Exception e) {
			logService.logError(userId, "getAlcoholByPrice " + price);
			return null;
		}
	}
	
	public AlcoholItem getAlcoholById(long id, Long userId) {
		try {
			AlcoholItem alcoholItem = alcoholRepository.findById(id);
			logService.logSuccess(userId, "getAlcoholItemByAlcoholId " + id);
			return alcoholItem;
		} catch (Exception e) {
			logService.logError(userId, "getAlcoholByAlcoholId " + id);
			return null;
		}
	}
}
