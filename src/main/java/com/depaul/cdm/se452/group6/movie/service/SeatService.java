package com.depaul.cdm.se452.group6.movie.service;

import com.depaul.cdm.se452.group6.movie.entity.Seat;
import com.depaul.cdm.se452.group6.movie.finder.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SeatService {

  private SeatRepository seatRepository;
  private LogService logService;

  public SeatService(SeatRepository seatRepository,
                     LogService logService) {
    this.seatRepository = seatRepository;
    this.logService = logService;
  }

  public List<Seat> getSeats() {
    try {
      List<Seat> seats = seatRepository.findAll();
      logService.logSuccess("test_user", "getAllSeats");
      return seats;
    } catch (Exception e) {
      logService.logError("test_user", "getAllSeats");
      return null;
    }
  }

  public List<Seat> getSeatsByTheater(Long theaterId) {
    try {
      List<Seat> seats = seatRepository.findByTheaterId(theaterId);
      logService.logSuccess("test_user", "getSeatsByTheater " + theaterId);
      return seats;
    } catch (Exception e) {
      logService.logError("test_user", "getSeatsByTheater " + theaterId);
      return null;
    }
  }
}
