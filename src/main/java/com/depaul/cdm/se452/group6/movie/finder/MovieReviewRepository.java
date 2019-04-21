package com.depaul.cdm.se452.group6.movie.finder;

import com.depaul.cdm.se452.group6.movie.entity.MovieReview;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface MovieReviewRepository extends CrudRepository<MovieReview, Long> {
  List<MovieReview> findByName (String name);
  List<MovieReview> findByNameAndYear (String name, Long year);
}
