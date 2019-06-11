package com.depaul.cdm.se452.group6.movie.service;

import com.depaul.cdm.se452.group6.movie.entity.Movie;
import com.depaul.cdm.se452.group6.movie.entity.Theater;
import com.depaul.cdm.se452.group6.movie.finder.TheaterRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class TheaterService {

  private TheaterRepository theaterRepository;
  private LogService logService;
  private MovieService movieService;

  public TheaterService (TheaterRepository theaterRepository, LogService logService, MovieService movieService) {
    this.theaterRepository = theaterRepository;
    this.logService = logService;
    this.movieService = movieService;
  }

  public Theater getById(Long id) {
    try {
      Theater theater = theaterRepository.findById(id).get();
      logService.logSuccess("testUser" , "got theater by id " + id);
      return theater;
    } catch (Exception e) {
      logService.logError("testUser", "error getting theater " + id);
      return null;
    }
  }

  public List<Theater> getByDateAndMovieID(LocalDate date, Movie movie) {
    try {
      List<Theater> theaters = theaterRepository.findByDateAndMovieID(date, movie);
      logService.logSuccess("testUser" , "got theater by date and movieid " + movie.getId());
      return theaters;
    } catch (Exception e) {
      logService.logError("testUser", "error getting theater by date and movieid " + movie.getId());
      return null;
    }
  }

  public List<Theater> getTheaters() {
    try {
      List<Theater> theaters = theaterRepository.findAll();
      logService.logSuccess("testUser" , "got theaters");
      return theaters;
    } catch (Exception e) {
      logService.logError("testUser", "error getting theaters ");
      return null;
    }
  }

  public List<Theater> getTheatersByDate(LocalDate date) {
    try {
      List<Theater> theaters = theaterRepository.findByDate(date);
      logService.logSuccess("testUser" , "got theater by date");
      return theaters;
    } catch (Exception e) {
      logService.logError("testUser", "error getting theater by date ");
      return null;
    }
  }
}
