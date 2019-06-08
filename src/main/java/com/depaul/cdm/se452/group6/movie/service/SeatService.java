package com.depaul.cdm.se452.group6.movie.service;

import com.depaul.cdm.se452.group6.movie.entity.Seat;
import com.depaul.cdm.se452.group6.movie.finder.SeatRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class SeatService {

  private SeatRepository seatRepository;
  private LogService logService;
  private EntityManager entityManager;

  public SeatService(SeatRepository seatRepository,
                     LogService logService,
                     EntityManager entityManager) {
    this.seatRepository = seatRepository;
    this.logService = logService;
    this.entityManager = entityManager;
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

  public Seat getSeatById(long id) {
    try {
      Seat seat = seatRepository.findById(id);
      logService.logSuccess("test_user", "get seat by id");
      return seat;
    } catch (Exception e) {
      logService.logError("test_user", "get seat by id");
      return null;
    }
  }

  @Transactional
  public void updateSeat(Seat seat) {
    try {
      entityManager.persist(seat);
      entityManager.flush();
      logService.logSuccess("test_user", "updating seat");
    } catch (Exception e) {
      logService.logError("test_user", "updating seat");
    }
  }
}
