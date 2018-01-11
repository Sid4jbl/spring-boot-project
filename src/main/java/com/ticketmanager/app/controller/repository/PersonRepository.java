package com.ticketmanager.app.controller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketmanager.app.entity.Person;

public interface PersonRepository extends JpaRepository<Person,Integer> {
	
	public Person findFirstNameByAadharNumber(String aadharNumber);
	public List<Person> findFirstNameAndLastNameByMaritalStatus (boolean isMarried);

}
