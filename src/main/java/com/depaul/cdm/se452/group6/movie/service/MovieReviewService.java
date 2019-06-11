package com.depaul.cdm.se452.group6.movie.service;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.depaul.cdm.se452.group6.movie.entity.MovieReview;
import com.depaul.cdm.se452.group6.movie.finder.MovieReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieReviewService {

  private MovieReviewRepository movieReviewRepository;
  private LogService logService;

  public MovieReviewService (MovieReviewRepository movieReviewRepository, LogService logService) {
    this.movieReviewRepository = movieReviewRepository;
    this.logService = logService;
  }

  public List<MovieReview> getReviews() {
    try {
      List<MovieReview> reviews = movieReviewRepository.findAll();
      logService.logSuccess("testUser" , "got all reviews");
      return reviews;
    } catch (Exception e) {
      logService.logError("testUser", "error getting all reviews");
      return null;
    }
  }

  public List<MovieReview> getReviewsByMovie(Long id) {
    try {
      List<MovieReview> reviews = movieReviewRepository.findByMovieID(id);
      logService.logSuccess("testUser" , "got reviews by movieid" + id);
      return reviews;
    } catch (Exception e) {
      logService.logError("testUser", "error getting reviews by movieid" + id);
      return null;
    }
  }

  public List<MovieReview> getReviewsByUserID(Long id) {
    try {
      List<MovieReview> reviews = movieReviewRepository.findByUserID(id);
      logService.logSuccess("testUser" , "got reviews by userid" + id);
      return reviews;
    } catch (Exception e) {
      logService.logError("testUser", "error getting reviews by userid" + id);
      return null;
    }
  }
}
