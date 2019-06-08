package com.depaul.cdm.se452.group6.movie.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "tickets")
public class Ticket implements Serializable {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "ticketid")
	  private Long id;
	  
	  @OneToOne
	  @JoinColumn(name = "seatid", nullable = false)
	  private Seat seat;
	  
	  @ManyToOne
	  @JoinColumn(name = "userid", nullable = false)
	  private User user;

}
