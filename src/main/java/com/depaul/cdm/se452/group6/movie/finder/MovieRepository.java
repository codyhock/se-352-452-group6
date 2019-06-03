package com.depaul.cdm.se452.group6.movie.finder;

import com.depaul.cdm.se452.group6.movie.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Long> {
  List<Movie> findByName (String name);
  List<Movie> findByNameAndYear (String name, int year);
  Movie findById (long id);

  @Override
  List<Movie> findAll();
}
