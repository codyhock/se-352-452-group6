package com.depaul.cdm.se452.group6.movie.finder;

import com.depaul.cdm.se452.group6.movie.entity.Drink;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface DrinkRepository extends CrudRepository<Drink, Long> {
	List<Drink> findByItem(String item);
}
