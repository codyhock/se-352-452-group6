package com.depaul.cdm.se452.group6.movie.controller;

import com.depaul.cdm.se452.group6.movie.entity.Movie;
import com.depaul.cdm.se452.group6.movie.entity.MovieReview;
import com.depaul.cdm.se452.group6.movie.entity.Theater;
import com.depaul.cdm.se452.group6.movie.entity.UserLogin;
import com.depaul.cdm.se452.group6.movie.finder.MovieRepository;
import com.depaul.cdm.se452.group6.movie.finder.MovieReviewRepository;
import com.depaul.cdm.se452.group6.movie.service.MovieReviewService;
import com.depaul.cdm.se452.group6.movie.service.TheaterService;
import com.depaul.cdm.se452.group6.movie.service.UserLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MovieReviewController {

  private MovieReviewService movieReviewService;
  private MovieRepository movieRepository;
  private MovieReviewRepository movieReviewRepository;
  private TheaterService theaterService;

  public MovieReviewController (MovieReviewService movieReviewService, MovieRepository movieRepository,
                                MovieReviewRepository movieReviewRepository, TheaterService theaterService) {

    this.movieReviewService = movieReviewService;
    this.movieRepository = movieRepository;
    this.movieReviewRepository = movieReviewRepository;
    this.theaterService = theaterService;
  }

  @GetMapping("reviews/movie/{movieId}")
  public String getByTheater(@PathVariable long movieId, Model model,
                             @SessionAttribute(name="theaters") Long[] theaterIDs) {

    List<MovieReview> reviews = movieReviewService.getReviewsByMovie(movieId);
    Movie movie = movieRepository.findById(movieId);
    double ratingSum = 0;
    for (MovieReview review: reviews) {
      ratingSum += review.getRating();
    }
    if (reviews.size() > 0) {
      ratingSum = ratingSum / reviews.size();
    }

    List<Theater> theaters = new ArrayList<Theater>();
    for (Long theaterID : theaterIDs) {
      theaters.add(theaterService.getById(theaterID));
    }

    String avgRating = String.format("%.2f", ratingSum);
    model.addAttribute("theaters", theaters);
    model.addAttribute("avgRating", avgRating);
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
    newReview.setUserName("admin"); //Hardcoded for now}
    newReview.setMovieID(movieId);
    movieReviewRepository.save(newReview);
    return "redirect:/reviews/movie/" + movieId;
  }
}
