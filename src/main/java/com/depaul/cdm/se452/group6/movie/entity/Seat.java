package com.depaul.cdm.se452.group6.movie.entity;

import javax.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {

  @Id
  @GeneratedValue
  private Long id;

  // seat_num
  @Column(name="seat_number")
  private Long seatNumber;

  // seat_type
  @Column(name="seat_type")
  private String seatType;

  @ManyToOne
  @JoinColumn(name = "theater_id", nullable = false)
  private Theater theater;
}
