package com.depaul.cdm.se452.group6.movie.controller;

import com.depaul.cdm.se452.group6.movie.entity.*;
import com.depaul.cdm.se452.group6.movie.model.PreOrder;
import com.depaul.cdm.se452.group6.movie.model.Seats;
import com.depaul.cdm.se452.group6.movie.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SeatController {

  private SeatService seatService;
  private TheaterService theaterService;
  private MovieService movieService;
  private CartService cartService;
  private TicketService ticketService;
  private UserService userService;

  public SeatController(SeatService seatService, TheaterService theaterService, MovieService movieService, CartService cartService, TicketService ticketService, UserService userService) {
    this.seatService = seatService;
    this.theaterService = theaterService;
    this.movieService = movieService;
    this.cartService = cartService;
    this.ticketService = ticketService;
    this.userService = userService;
  }

  @GetMapping("theater/{theaterId}/seats")
  public String getByTheater(@PathVariable long theaterId, Model model, @SessionAttribute(name="userID") Long userID) {
    Theater theater = theaterService.getById(theaterId, userID);
    Movie movie = movieService.getMovie(theater.getMovieID().getId());
    List<Seat> seats = seatService.getSeatsByTheater(theaterId, userID);
    List<SeatType> seatTypes = seatService.getSeatTypes(userID);
    model.addAttribute("seats", seats);
    model.addAttribute("form", seats);
    model.addAttribute("movieName", movie.getName());
    model.addAttribute("date", theater.getDate());
    model.addAttribute("time", theater.getTime());
    model.addAttribute("theaterType", theater.getTheaterType().getType());
    model.addAttribute("screen", theater.getTheater());
    model.addAttribute("userSeats", new Seats());
    model.addAttribute("seatTypes", seatTypes);
    return "seat";
  }

  @RequestMapping(value="/seats", method=RequestMethod.POST)
  public String submit(@ModelAttribute("selectedSeats") Seats userSeats, Model model,
                       @SessionAttribute(name="userID") Long userID) {
    List<Ticket> tickets = new ArrayList<Ticket>();
    for (Long seat : userSeats.getSelectedSeats()) {
      Seat s = seatService.getSeatById(seat, userID);
      s.setAvailability("Unavailable");
      seatService.updateSeat(s, userID);
      Ticket t = new Ticket();
      t.setSeat(s);
      t.setUser(userService.findByUserId(userID, userID));
      tickets.add(ticketService.createTicket(t, userID));
    }

    List<Long> ticketIds = new ArrayList<>();
    for (Ticket ticket : tickets) {
      ticketIds.add(ticket.getId());
    }

    cartService.createTicket(userID, ticketIds);

    return "redirect:/preorder/form";
  }

}
