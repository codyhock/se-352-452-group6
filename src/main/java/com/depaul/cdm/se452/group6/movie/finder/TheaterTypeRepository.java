package com.depaul.cdm.se452.group6.movie.finder;

import com.depaul.cdm.se452.group6.movie.entity.TheaterType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TheaterTypeRepository extends CrudRepository<TheaterType, Long> {
  List<TheaterType> findByType(String type);
}
