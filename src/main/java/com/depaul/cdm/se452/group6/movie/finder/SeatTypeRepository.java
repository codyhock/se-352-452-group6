package com.depaul.cdm.se452.group6.movie.finder;

import com.depaul.cdm.se452.group6.movie.entity.SeatType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SeatTypeRepository extends CrudRepository<SeatType, Long> {
  Optional<SeatType> findByType(String type);
  List<SeatType> findAll();
}
