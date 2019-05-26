package com.depaul.cdm.se452.group6.movie.finder;

import com.depaul.cdm.se452.group6.movie.entity.Food;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface FoodRepository extends CrudRepository<Food, Long> {
	List<Food> findAll();
	List<Food> findByItem(String item);
	List<Food> findByItemAndSize(String item, String size);
	
//	Optional<Food> findById(Long id);
}
