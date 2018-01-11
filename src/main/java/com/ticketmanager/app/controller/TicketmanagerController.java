package com.ticketmanager.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ticketmanager.app.entity.TicketmanagerEntity;
import com.ticketmanager.app.service.TicketmanagerService;

@RestController
@RequestMapping(value="/ticketManagingApp/tickets")
public class TicketmanagerController {
	
	@Autowired
	private TicketmanagerService ticketmanagerService;
	
	@GetMapping(value="*")
	public ResponseEntity<String> getErrorMessage() {
		return new ResponseEntity<String>("The requested URL is not found..Please try again..!!!", HttpStatus.BAD_GATEWAY);
	}
	
	@GetMapping(value="/getAllTickets")
	public List<TicketmanagerEntity> getAllTickets() {
		return ticketmanagerService.getAllTickets();
	}
	
	@PostMapping(value="/createTicket")
	public TicketmanagerEntity createTicket(@RequestBody TicketmanagerEntity ticketmanagerEntity)
	{
		return ticketmanagerService.createTicket(ticketmanagerEntity);
	}
	
	@GetMapping(value="/getTicket/{ticketID}")
	public TicketmanagerEntity getTicket(@PathVariable(value = "ticketID") Integer ticketId) {
		return ticketmanagerService.getTicket(ticketId);
	}
	
	@PostMapping(value="/updateTicket/{ticketID}/{passengerName}")
	public TicketmanagerEntity updateTicket(@PathVariable("ticketID") Integer ticketId, @PathVariable("passengerName") String passengerName) {
		return ticketmanagerService.updateTicket(ticketId,passengerName);
	}
	
	@DeleteMapping(value="/deleteTickett/{ticketID}")
	public String deleteTicket(@PathVariable("ticketID") Integer ticketId) {
		return ticketmanagerService.deleteTicket(ticketId);
	}
	
	@PostMapping(value="/searchByName/{passengerName}")
	public TicketmanagerEntity searchByName(@PathVariable("passengerName") String passengerName) {
		return ticketmanagerService.searchByName(passengerName);
	}
	
	@PostMapping(value="/searchAllByNameAndFare/{passengerName}/{fare}")
	public List<TicketmanagerEntity> searchAllByNameAndFare(@PathVariable("passengerName") String passengerName,@PathVariable("fare") double fare) {
		return ticketmanagerService.searchAllByNameAndFare(passengerName,fare);
	}
	

}
