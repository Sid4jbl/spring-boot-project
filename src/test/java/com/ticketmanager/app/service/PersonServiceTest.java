package com.ticketmanager.app.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ticketmanager.app.controller.repository.PersonRepository;
import com.ticketmanager.app.entity.Person;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {
	
	@MockBean
	private PersonRepository personRepository;
	
	@Autowired
	private PersonService  personService;
	
	
	@Test
	public void testSavePersonDetails() {
		
		
		Person person = new Person();
		person.setAadharNumber("123qwe");
		person.setDob(new Date());
		person.setFirstName("Ram");
		person.setLastName("lakshman");
		person.setPanNumber("ajdps1209a");
		person.setMarried(false);
		person.setSex('M');
		
		when(personRepository.save(person)).thenReturn(person);
		assertThat(personService.savePersonDetails(person)).isEqualTo(person);
	}

	@Test
	public void testGetFirstNamebyAdhar() {
		
		Person person = new Person();
		person.setAadharNumber("123qwe");
		person.setDob(new Date());
		person.setFirstName("Ram");
		person.setLastName("lakshman");
		person.setPanNumber("ajdps1209a");
		person.setMarried(false);
		person.setSex('M');
		
		when(personRepository.findFirstNameByAadharNumber("ajdps1209a")).thenReturn(person);
		assertThat(personService.getFirstNamebyAdhar("ajdps1209a")).isEqualTo(person);
	}

	@Test
	public void testGetFirstLastNamebyMarritalStatus() {
		
		List<Person> persons = Collections.singletonList(new Person());
		when(personRepository.findFirstNameAndLastNameByMaritalStatus(true)).thenReturn(persons);
		assertThat(personService.getFirstLastNamebyMarritalStatus(true)).isEqualTo(persons);
	}

}
