package com.depaul.cdm.se452.group6.movie.finder;

import com.depaul.cdm.se452.group6.movie.entity.Seat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SeatRepository extends CrudRepository<Seat, Long> {

  List<Seat> findAll();
  List<Seat> findByTheaterId(Long theaterId);
  Optional<Seat> findById(Long id);
}
