package com.depaul.cdm.se452.group6.movie.finder;

import com.depaul.cdm.se452.group6.movie.entity.AlcoholItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlcoholItemRepository extends CrudRepository<AlcoholItem, Long> {

    List<AlcoholItem> findByType(String type);

    List<AlcoholItem> findByPrice(Double price);
    
    List<AlcoholItem> findAll();

}
