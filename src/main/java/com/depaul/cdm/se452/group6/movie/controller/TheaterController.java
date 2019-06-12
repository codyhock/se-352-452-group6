package com.depaul.cdm.se452.group6.movie.controller;

import com.depaul.cdm.se452.group6.movie.entity.Theater;
import com.depaul.cdm.se452.group6.movie.model.Theaters;
import com.depaul.cdm.se452.group6.movie.service.TheaterService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
  public String getMoviesByDate(Model model, @SessionAttribute(name="userID") Long userID) {
    /*
    Date hardcoded for initial view as we would have to populate tables for many
    future dates to display current date availability
     */
    LocalDate date = LocalDate.of(2019,4,13);
    List<Theater> theaters = theaterService.getTheatersByDate(date, userID);
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

    model.addAttribute("theaters", new Theaters());
    return "movies";
  }

  @PostMapping("/movies/{id}/addReview")
  public String reviewRedirect(@ModelAttribute("theaters") Theaters theaters, @PathVariable Long id,
                               Model model, BindingResult result, HttpServletRequest request) {

    //HttpSession session = request.getSession(true);
    HttpSession session = request.getSession();
    session.setAttribute("theaters", theaters.getTheaters());
    return "redirect:/reviews/movie/" + id;
  }
}
