package com.depaul.cdm.se452.group6.movie.service;

import com.depaul.cdm.se452.group6.movie.entity.Seat;
import com.depaul.cdm.se452.group6.movie.entity.Ticket;
import com.depaul.cdm.se452.group6.movie.finder.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
	
	private TicketRepository ticketRepository;
	private LogService logService;
	
	public TicketService(TicketRepository ticketRepository,
 						 LogService logService) {
		this.ticketRepository = ticketRepository;
		this.logService = logService;
	}
	
	public List<Ticket> getTickets() {
		 try {
			 List<Ticket> tickets = ticketRepository.findAll();
			 logService.logSuccess("test_user", "getAllTickets");
		     return tickets;
		 }	 catch (Exception e) {
			 logService.logError("test_user", "getAllTickets");
		     return null;
		     }
	}
	
	public List<Ticket> findTicketsByid(Long ticketid) {
		 try {
			 List<Ticket> tickets = ticketRepository.findByid(ticketid);
			 logService.logSuccess("test_user", "findByid" + ticketid);
		     return tickets;
		 }	 catch (Exception e) {
			 logService.logError("test_user", "findByid" + ticketid);
		     return null;
		     }
	}
	
	public List<Ticket> findTicketsByUser(Seat seat) {
		 try {
			 List<Ticket> tickets = ticketRepository.findByUser(seat);
			 logService.logSuccess("test_user", "findByUser" + seat);
		     return tickets;
		 }	 catch (Exception e) {
			 logService.logError("test_user", "findByUser" + seat);
		     return null;
		     }
	}

}
