package com.depaul.cdm.se452.group6.movie.controller;

import com.depaul.cdm.se452.group6.movie.service.SeatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SeatController {

  private SeatService seatService;

  public SeatController(SeatService seatService) {
    this.seatService = seatService;
  }

  @GetMapping("theater/{theaterId}/seats")
  public String getByTheater(@PathVariable long theaterId, Model model) {
    model.addAttribute("seats", seatService.getSeatsByTheater(theaterId));
    return "seat";
  }

}
