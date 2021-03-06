package com.depaul.cdm.se452.group6.movie.finder;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.depaul.cdm.se452.group6.movie.entity.Seat;
import com.depaul.cdm.se452.group6.movie.entity.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
	
	List<Ticket> findAll();

	List<Ticket> findByid(Long id);

	List<Ticket> findByUser(Seat sear);

	Ticket findBySeat(Seat seat);
}
