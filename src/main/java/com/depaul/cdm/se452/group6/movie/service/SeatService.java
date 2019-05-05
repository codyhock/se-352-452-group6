package com.depaul.cdm.se452.group6.movie.service;

import com.depaul.cdm.se452.group6.movie.entity.Seat;
import com.depaul.cdm.se452.group6.movie.finder.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

  private SeatRepository seatRepository;

  public SeatService(SeatRepository seatRepository) {
    this.seatRepository = seatRepository;
  }

  public List<Seat> getSeats() {
    return seatRepository.findAll();
  }

  public List<Seat> getSeatsByTheater(Long theaterId) {
    return seatRepository.findByTheaterId(theaterId);
  }
}
