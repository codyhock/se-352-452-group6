package com.depaul.cdm.se452.group6.movie.service;


import com.depaul.cdm.se452.group6.movie.config.LogConfig;
import com.depaul.cdm.se452.group6.movie.config.LogLevel;
import com.depaul.cdm.se452.group6.movie.entity.Log;
import com.depaul.cdm.se452.group6.movie.finder.LogRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LogService {

  private LogRepository logRepository;
  private LogConfig logConfig;

  public LogService(LogRepository logRepository,
                    LogConfig logConfig) {
    this.logRepository = logRepository;
    this.logConfig = logConfig;
  }

  public List<Log> getAll() {
    return logRepository.findAll();
  }

  public Log logSuccess(String uName, String action) {
    Log log = new Log();
    if (LogLevel.valueOf(logConfig.getLevel()).equals(LogLevel.DEBUG)) {
      log.setUserName(uName);
      log.setAction(action);
      log.setResult("Success");
      log.setTimeStamp(new Date());
      logRepository.save(log);
    }
    return log;
  }

  public Log logError(String uName, String action) {
    Log log = new Log();
    if (LogLevel.valueOf(logConfig.getLevel()).equals(LogLevel.DEBUG)) {
      log.setUserName(uName);
      log.setAction(action);
      log.setResult("ERROR");
      log.setTimeStamp(new Date());
      logRepository.save(log);
    }
    return log;
  }

}
