package com.depaul.cdm.se452.group6.movie.service;

import com.depaul.cdm.se452.group6.movie.entity.Theater;
import com.depaul.cdm.se452.group6.movie.finder.TheaterRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class TheaterService {

  private TheaterRepository theaterRepository;

  public TheaterService (TheaterRepository theaterRepository) {
    this.theaterRepository = theaterRepository;
  }

  public List<Theater> getTheaters() {
    try {
      List<Theater> theaters = theaterRepository.findAll();
      return theaters;
    } catch (Exception e) {
      return null;
    }
  }

  public List<Theater> getTheatersByDate(LocalDate date) {
    try {
      List<Theater> theaters = theaterRepository.findByDate(date);
      return theaters;
    } catch (Exception e) {
      return null;
    }
  }
}
