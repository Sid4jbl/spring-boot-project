package com.ticketmanager.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticketmanager.app.entity.Person;
import com.ticketmanager.app.service.PersonService;

@RequestMapping(value="/personmanager/persons")
@RestController
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@PostMapping(value="/saveDetails")
	public Person savePersonDetails(@RequestBody Person person) {
		return personService.savePersonDetails(person);
	}
	
	@PostMapping(value="/adharnumbers/{aadharNumber}")
	public Person getFirstNamebyAdhar(@PathVariable(value="aadharnumber") String aadharNumber) {
		return personService.getFirstNamebyAdhar(aadharNumber);
	}
	
	@PostMapping(value="/maritalstatus/{married}")
	public List<Person> getFirstLastNamebyMarritalStatus(@PathVariable(value="married") boolean isMarried) {
		return personService.getFirstLastNamebyMarritalStatus(isMarried);
	}
}
