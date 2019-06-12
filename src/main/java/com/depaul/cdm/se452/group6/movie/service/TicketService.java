package com.depaul.cdm.se452.group6.movie.service;

import com.depaul.cdm.se452.group6.movie.entity.Seat;
import com.depaul.cdm.se452.group6.movie.entity.Ticket;
import com.depaul.cdm.se452.group6.movie.finder.TicketRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class TicketService {
	
	private TicketRepository ticketRepository;
	private LogService logService;
	private EntityManager entityManager;
	
	public TicketService(TicketRepository ticketRepository,
 						 						LogService logService,
											 EntityManager entityManager) {
		this.ticketRepository = ticketRepository;
		this.logService = logService;
		this.entityManager = entityManager;
	}

	@Transactional
	public Ticket createTicket(Ticket t, Long userId) {
		try {
			entityManager.persist(t);
			entityManager.flush();
			ticketRepository.findBySeat(t.getSeat());
			return ticketRepository.findBySeat(t.getSeat());
		} catch (Exception e) {
			logService.logError(userId, "create ticket");
			return null;
		}
	}
	
	public List<Ticket> getTickets(Long userId) {
		 try {
			 List<Ticket> tickets = ticketRepository.findAll();
			 logService.logSuccess(userId, "getAllTickets");
		     return tickets;
		 }	 catch (Exception e) {
			 logService.logError(userId, "getAllTickets");
		     return null;
		     }
	}
	
	public List<Ticket> findTicketsByid(Long ticketid, Long userId) {
		 try {
			 List<Ticket> tickets = ticketRepository.findByid(ticketid);
			 logService.logSuccess(userId, "findByid" + ticketid);
		     return tickets;
		 }	 catch (Exception e) {
			 logService.logError(userId, "findByid" + ticketid);
		     return null;
		     }
	}

	public void deleteTicket(Ticket ticket) {
		ticketRepository.delete(ticket);
	}
	
	public List<Ticket> findTicketsByUser(Seat seat, Long userId) {
		 try {
			 List<Ticket> tickets = ticketRepository.findByUser(seat);
			 logService.logSuccess(userId, "findByUser" + seat);
		     return tickets;
		 }	 catch (Exception e) {
			 logService.logError(userId, "findByUser" + seat);
		     return null;
		     }
	}

}
