package com.depaul.cdm.se452.group6.movie.controller;

import com.depaul.cdm.se452.group6.movie.entity.Seat;
import com.depaul.cdm.se452.group6.movie.service.SeatService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {

  private SeatService seatService;

  public SeatController(SeatService seatService) {
    this.seatService = seatService;
  }

  @RequestMapping(method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public List<Seat> getAll() {
    return seatService.getSeats();
  }


  @RequestMapping(method = RequestMethod.GET, value = "/{theaterId}")
  @ResponseStatus(HttpStatus.OK)
  public List<Seat> getByTheater(@PathVariable long theaterId) {
    return seatService.getSeatsByTheater(theaterId);
  }

}
