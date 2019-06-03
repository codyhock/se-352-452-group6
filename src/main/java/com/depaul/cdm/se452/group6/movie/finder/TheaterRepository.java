package com.depaul.cdm.se452.group6.movie.finder;

import com.depaul.cdm.se452.group6.movie.entity.Theater;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface TheaterRepository extends CrudRepository<Theater, Long> {
  List<Theater> findByTheater (int theater);
  List<Theater> findByTheaterAndDate (int theater, LocalDate date);
  List<Theater> findByTheaterAndDateAndTime (int theater, LocalDate date, LocalTime time);
  List<Theater> findByDate (LocalDate date);

  @Override
  List<Theater> findAll();
}
