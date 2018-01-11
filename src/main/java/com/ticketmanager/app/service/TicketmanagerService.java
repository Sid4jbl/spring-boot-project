package com.ticketmanager.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ticketmanager.app.controller.repository.TicketmanagerRepository;
import com.ticketmanager.app.entity.TicketmanagerEntity;

@Service
public class TicketmanagerService {

	@Autowired
	private TicketmanagerRepository ticketmanagerRepository;
	
	public List<TicketmanagerEntity> getAllTickets() {
		// TODO Auto-generated method stub
		return (List<TicketmanagerEntity>) ticketmanagerRepository.findAll();
	}

	public TicketmanagerEntity createTicket(TicketmanagerEntity ticketmanagerEntity) {
		// TODO Auto-generated method stub
		return ticketmanagerRepository.save(ticketmanagerEntity);
	}

	public TicketmanagerEntity getTicket(Integer ticketId) {
		// TODO Auto-generated method stub
		return ticketmanagerRepository.findOne(ticketId);
	}

	public TicketmanagerEntity updateTicket(Integer ticketId, String passengerName) {
		// TODO Auto-generated method stub
		TicketmanagerEntity ticket = ticketmanagerRepository.findOne(ticketId);
		ticket.setPassengerName(passengerName);
		return ticketmanagerRepository.save(ticket);
	}

	public String deleteTicket(Integer ticketId) {
		// TODO Auto-generated method stub
		ticketmanagerRepository.delete(ticketId);
		return "deleted Successfully";
	}

	public TicketmanagerEntity searchByName(String passengerName) {
		// TODO Auto-generated method stub
		return ticketmanagerRepository.findOneByPassengerName(passengerName);
	}

	public List<TicketmanagerEntity> searchAllByNameAndFare(String passengerName, double fare) {
		// TODO Auto-generated method stub
		return ticketmanagerRepository.findByPassengerNameAndFareAllIgnoreCase(passengerName,fare);
	}
	

}
