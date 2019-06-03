package com.depaul.cdm.se452.group6.movie.controller;

import com.depaul.cdm.se452.group6.movie.entity.Movie;
import com.depaul.cdm.se452.group6.movie.entity.MovieReview;
import com.depaul.cdm.se452.group6.movie.finder.MovieRepository;
import com.depaul.cdm.se452.group6.movie.service.MovieReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class MovieReviewController {

  private MovieReviewService movieReviewService;
  private MovieRepository movieRepository;

  public MovieReviewController (MovieReviewService movieReviewService, MovieRepository movieRepository) {
    this.movieReviewService = movieReviewService;
    this.movieRepository = movieRepository;
  }

  @GetMapping("reviews/movie/{movieId}")
  public String getByTheater(@PathVariable long movieId, Model model) {
    List<MovieReview> reviews = movieReviewService.getReviewsByMovie(movieId);
    Movie movie = movieRepository.findById(movieId);
    model.addAttribute("reviews", reviews);
    model.addAttribute("movie", movie);
    return "reviews";
  }
}
