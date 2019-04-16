package com.depaul.cdm.se452.group6.movie.finder;

import com.depaul.cdm.se452.group6.movie.entity.Theater;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface TheaterRepository extends CrudRepository<Theater, Long> {
  List<Theater> findByid (Long id);
}
