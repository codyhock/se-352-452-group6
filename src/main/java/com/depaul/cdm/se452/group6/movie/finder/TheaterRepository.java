package com.depaul.cdm.se452.group6.movie.finder;

import com.depaul.cdm.se452.group6.movie.entity.Theater;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.sql.Timestamp;

public interface TheaterRepository extends CrudRepository<Theater, Long> {
  List<Theater> findByTheater (Long theater);
  List<Theater> findByTheaterAndTime (Long theater, Timestamp Time);
}
