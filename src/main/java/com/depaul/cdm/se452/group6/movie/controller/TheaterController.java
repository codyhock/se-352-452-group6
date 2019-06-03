package com.depaul.cdm.se452.group6.movie.controller;

import com.depaul.cdm.se452.group6.movie.entity.Theater;
import com.depaul.cdm.se452.group6.movie.service.TheaterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class TheaterController {

  private TheaterService theaterService;

  public TheaterController (TheaterService theaterService) {
    this.theaterService = theaterService;
  }

  @GetMapping("movie-listings")
  public String getMoviesByDate(Model model) {
    List<Theater> theaters = theaterService.getTheatersByDate(LocalDate.of(2019, 4, 13));
    //model.addAttribute("theaters", theaterService.getTheatersByDate(LocalDate.of(2019, 4, 13)));
    HashMap<String, ArrayList<Theater>> movies = new HashMap<>();
    for (Theater theater: theaters) {
        String name = theater.getMovieID().getName();
        if (!movies.containsKey(name)) {
          movies.put(name, new ArrayList<Theater>());
          movies.get(name).add(theater);
        }
        else {
          movies.get(name).add(theater);
        }
      }

    model.addAttribute("movies", movies);
    return "movies";
  }
}
