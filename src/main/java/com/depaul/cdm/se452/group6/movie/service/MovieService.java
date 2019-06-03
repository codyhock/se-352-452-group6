package com.depaul.cdm.se452.group6.movie.service;

import com.depaul.cdm.se452.group6.movie.entity.Movie;
import com.depaul.cdm.se452.group6.movie.finder.MovieRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieService {

  private MovieRepository movieRepository;

  public MovieService (MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  public List<Movie> getMovies() {
    try {
      List<Movie> movies = movieRepository.findAll();
      return movies;
    } catch (Exception e) {
      return null;
    }
  }

  public Movie getMovie(long id) {
    try {
      Movie movie = movieRepository.findById(id);
      return movie;
    } catch (Exception e) {
      return null;
    }
  }
}
