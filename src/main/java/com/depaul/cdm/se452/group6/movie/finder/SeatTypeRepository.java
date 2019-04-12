package com.depaul.cdm.se452.group6.movie.finder;

import com.depaul.cdm.se452.group6.movie.entity.SeatType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SeatTypeRepository extends CrudRepository<SeatType, Long> {
  List<SeatType> findByType(String type);
}
