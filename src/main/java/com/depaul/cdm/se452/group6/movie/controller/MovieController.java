package com.depaul.cdm.se452.group6.movie.controller;

import com.depaul.cdm.se452.group6.movie.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MovieController {

  private MovieService movieService;

  public MovieController (MovieService movieService) {
    this.movieService = movieService;
  }

  @GetMapping("movies/{movieId}")
  public String getByMovieID(@PathVariable long movieId, Model model) {
    model.addAttribute("movie", movieService.getMovie(movieId));
    return "movie";
  }
}
