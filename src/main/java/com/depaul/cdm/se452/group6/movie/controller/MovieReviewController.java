package com.depaul.cdm.se452.group6.movie.controller;

import com.depaul.cdm.se452.group6.movie.entity.Movie;
import com.depaul.cdm.se452.group6.movie.entity.MovieReview;
import com.depaul.cdm.se452.group6.movie.finder.MovieRepository;
import com.depaul.cdm.se452.group6.movie.finder.MovieReviewRepository;
import com.depaul.cdm.se452.group6.movie.service.MovieReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MovieReviewController {

  private MovieReviewService movieReviewService;
  private MovieRepository movieRepository;
  private MovieReviewRepository movieReviewRepository;

  public MovieReviewController (MovieReviewService movieReviewService, MovieRepository movieRepository, MovieReviewRepository movieReviewRepository) {
    this.movieReviewService = movieReviewService;
    this.movieRepository = movieRepository;
    this.movieReviewRepository = movieReviewRepository;
  }

  @GetMapping("reviews/movie/{movieId}")
  public String getByTheater(@PathVariable long movieId, Model model) {
    List<MovieReview> reviews = movieReviewService.getReviewsByMovie(movieId);
    Movie movie = movieRepository.findById(movieId);
    double currentRating = 0;
    for (MovieReview review: reviews) {
      currentRating += review.getRating();
    }
    if (reviews.size() > 0) {
      currentRating = (double) currentRating / reviews.size();
    }
    model.addAttribute("currentRating", currentRating);
    model.addAttribute("reviews", reviews);
    model.addAttribute("movie", movie);
    model.addAttribute("newReview", new MovieReview());
    return "reviews";
  }

  @PostMapping("reviews/movie/{movieId}/addReview")
  public String addReview(@PathVariable long movieId, @Valid MovieReview newReview, BindingResult result) {
    if (result.hasErrors()) {
      return "redirect:/reviews/movie/" + movieId;
    }
    newReview.setUserID(1L); //Hardcoded for now
    newReview.setUserName("Neal"); //Hardcoded for now}
    newReview.setMovieID(movieId);
    movieReviewRepository.save(newReview);
    return "redirect:/reviews/movie/" + movieId;
  }
}
