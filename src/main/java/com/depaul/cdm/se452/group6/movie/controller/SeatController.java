package com.depaul.cdm.se452.group6.movie.controller;

import com.depaul.cdm.se452.group6.movie.entity.Seat;
import com.depaul.cdm.se452.group6.movie.service.SeatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SeatController {

  private SeatService seatService;

  public SeatController(SeatService seatService) {
    this.seatService = seatService;
  }

  @GetMapping("theater/{theaterId}/seats")
  public String getByTheater(@PathVariable long theaterId, Model model) {
    List<Seat> seats = seatService.getSeatsByTheater(theaterId);
    model.addAttribute("seats", seats);
    model.addAttribute("form", seats);
    return "seat";
  }

  @RequestMapping(value="/seats/submit", method=RequestMethod.POST)
  public String submit(Model model) {
    System.out.println("POSTING THE SEATS");
    return "redirect:/profile";
  }

}
