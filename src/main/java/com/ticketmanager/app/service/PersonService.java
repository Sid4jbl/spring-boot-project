package com.ticketmanager.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketmanager.app.controller.repository.PersonRepository;
import com.ticketmanager.app.entity.Person;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	public Person savePersonDetails(Person person)
	{
		return personRepository.save(person);
	}

	public Person getFirstNamebyAdhar(String aadharNumber) {
		// TODO Auto-generated method stub
		return personRepository.findFirstNameByAadharNumber(aadharNumber);
	}

	public List<Person> getFirstLastNamebyMarritalStatus(boolean married) {
		// TODO Auto-generated method stub
		return personRepository.findFirstNameAndLastNameByMaritalStatus(married);
	}
	
}
 