package com.depaul.cdm.se452.group6.movie.controller;

import com.depaul.cdm.se452.group6.movie.entity.Movie;
import com.depaul.cdm.se452.group6.movie.entity.Seat;
import com.depaul.cdm.se452.group6.movie.entity.Theater;
import com.depaul.cdm.se452.group6.movie.service.MovieService;
import com.depaul.cdm.se452.group6.movie.service.SeatService;
import com.depaul.cdm.se452.group6.movie.service.TheaterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SeatController {

  private SeatService seatService;
  private TheaterService theaterService;
  private MovieService movieService;

  public SeatController(SeatService seatService, TheaterService theaterService, MovieService movieService) {
    this.seatService = seatService;
    this.theaterService = theaterService;
    this.movieService = movieService;
  }

  @GetMapping("theater/{theaterId}/seats")
  public String getByTheater(@PathVariable long theaterId, Model model) {
    Theater theater = theaterService.getById(theaterId);
    Movie movie = movieService.getMovie(theater.getMovieID().getId());
    List<Seat> seats = seatService.getSeatsByTheater(theaterId);
    model.addAttribute("seats", seats);
    model.addAttribute("form", seats);
    model.addAttribute("movieName", movie.getName());
    return "seat";
  }

  @RequestMapping(value="/seats/submit", method=RequestMethod.POST)
  public String submit(Model model) {
    System.out.println("POSTING THE SEATS");
    return "redirect:/profile";
  }

}
