package com.depaul.cdm.se452.group6.movie.service;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.depaul.cdm.se452.group6.movie.entity.MovieReview;
import com.depaul.cdm.se452.group6.movie.finder.MovieReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieReviewService {

  private MovieReviewRepository movieReviewRepository;

  public MovieReviewService (MovieReviewRepository movieReviewRepository) {
    this.movieReviewRepository = movieReviewRepository;
  }

  public List<MovieReview> getReviews() {
    try {
      List<MovieReview> reviews = movieReviewRepository.findAll();
      return reviews;
    } catch (Exception e) {
      return null;
    }
  }

  public List<MovieReview> getReviewsByMovie(Long id) {
    try {
      List<MovieReview> reviews = movieReviewRepository.findByMovieID(id);
      return reviews;
    } catch (Exception e) {
      return null;
    }
  }

  public List<MovieReview> getReviewsByUser(Long id) {
    try {
      List<MovieReview> reviews = movieReviewRepository.findByUserID(id);
      return reviews;
    } catch (Exception e) {
      return null;
    }
  }
}
