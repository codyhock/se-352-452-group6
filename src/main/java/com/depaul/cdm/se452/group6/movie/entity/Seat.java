package com.depaul.cdm.se452.group6.movie.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "seats")
public class Seat {

  @Id
  @GeneratedValue
  private Long id;

  // seat_num
  @Column(name="seat_number")
  private Long seatNumber;

  // availability
  @Column(name="availability")
  private String availability;

  // seat_type
  @ManyToOne
  @JoinColumn(name="seat_type_id", nullable = false)
  private SeatType seatType;

  @ManyToOne
  @JoinColumn(name = "theater_id", nullable = false)
  private Theater theater;
}
