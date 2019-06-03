package com.depaul.cdm.se452.group6.movie.finder;

import com.depaul.cdm.se452.group6.movie.entity.MovieReview;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface MovieReviewRepository extends CrudRepository<MovieReview, Long> {
  List<MovieReview> findByUserID (Long id);
  List<MovieReview> findByMovieID (Long id);

  @Override
  List<MovieReview> findAll();
}
