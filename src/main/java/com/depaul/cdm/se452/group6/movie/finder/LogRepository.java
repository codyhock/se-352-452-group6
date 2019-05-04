package com.depaul.cdm.se452.group6.movie.finder;

import com.depaul.cdm.se452.group6.movie.entity.Log;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface LogRepository extends CrudRepository<Log, Long> {
  List<Log> findByUserName (String userName);
  List<Log> findByTimeStamp (Date timeStamp);
}
