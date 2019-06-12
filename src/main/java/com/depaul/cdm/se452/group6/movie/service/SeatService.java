package com.depaul.cdm.se452.group6.movie.service;

import com.depaul.cdm.se452.group6.movie.entity.Seat;
import com.depaul.cdm.se452.group6.movie.entity.SeatType;
import com.depaul.cdm.se452.group6.movie.finder.SeatRepository;
import com.depaul.cdm.se452.group6.movie.finder.SeatTypeRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class SeatService {

  private SeatRepository seatRepository;
  private SeatTypeRepository seatTypeRepository;
  private LogService logService;
  private EntityManager entityManager;

  public SeatService(SeatRepository seatRepository,
                     SeatTypeRepository seatTypeRepository,
                     LogService logService,
                     EntityManager entityManager) {
    this.seatRepository = seatRepository;
    this.logService = logService;
    this.entityManager = entityManager;
    this.seatTypeRepository = seatTypeRepository;
  }

  public List<Seat> getSeats(Long userId) {
    try {
      List<Seat> seats = seatRepository.findAll();
      logService.logSuccess(userId, "getAllSeats");
      return seats;
    } catch (Exception e) {
      logService.logError(userId, "getAllSeats");
      return null;
    }
  }

  public List<Seat> getSeatsByTheater(Long theaterId, Long userId) {
    try {
      List<Seat> seats = seatRepository.findByTheaterId(theaterId);
      logService.logSuccess(userId, "getSeatsByTheater " + theaterId);
      return seats;
    } catch (Exception e) {
      logService.logError(userId, "getSeatsByTheater " + theaterId);
      return null;
    }
  }

  public Seat getSeatById(long id, Long userId) {
    try {
      Seat seat = seatRepository.findById(id);
      logService.logSuccess(userId, "get seat by id");
      return seat;
    } catch (Exception e) {
      logService.logError(userId, "get seat by id");
      return null;
    }
  }

  public List<SeatType> getSeatTypes(Long userId) {
    try {
      List<SeatType> seatTypes = seatTypeRepository.findAll();
      logService.logSuccess(userId, "get all seat types");
      return seatTypes;
    } catch (Exception e) {
      logService.logError(userId, "get all seat types");
      return null;
    }
  }

  @Transactional
  public void updateSeat(Seat seat, Long userId) {
    try {
      entityManager.persist(seat);
      entityManager.flush();
      logService.logSuccess(userId, "updating seat");
    } catch (Exception e) {
      logService.logError(userId, "updating seat");
    }
  }
}
