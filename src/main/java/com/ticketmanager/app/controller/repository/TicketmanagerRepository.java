package com.ticketmanager.app.controller.repository;

import java.util.List;

import javax.validation.constraints.Null;

import org.springframework.data.repository.CrudRepository;

import com.ticketmanager.app.entity.TicketmanagerEntity;

public interface TicketmanagerRepository extends CrudRepository<TicketmanagerEntity, Integer> {
	
	public TicketmanagerEntity findOneByPassengerName(String passengerName);
	
	//public List<TicketmanagerEntity> findByPassengerNameAndFare(String passengerName,double fare); // Should match the datatype with its entity
	
	//public List<TicketmanagerEntity> findByPassengerNameAndFareAllIgnoreCase(String passengerName,double fare); //Makes it case insensitive
	
	public List<TicketmanagerEntity> findByPassengerNameAndFareAllIgnoreCase(String passengerName,@Null double fare); //optional fare

}
