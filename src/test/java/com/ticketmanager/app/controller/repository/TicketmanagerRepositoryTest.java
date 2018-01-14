package com.ticketmanager.app.controller.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.ticketmanager.app.entity.TicketmanagerEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TicketmanagerRepositoryTest {
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Autowired
	private TicketmanagerRepository ticketmanagerRepository;

	@Test
	public void testFindAll() {
		TicketmanagerEntity ticketmanagerEntity1 = getMockTicket1();
		TicketmanagerEntity ticketmanagerEntity2 = getMockTicket2();
		TicketmanagerEntity savedInDb1 = testEntityManager.persist(ticketmanagerEntity1);
		TicketmanagerEntity savedInDb = testEntityManager.persist(ticketmanagerEntity2);
		Iterable<TicketmanagerEntity>  retrievedFromDb = ticketmanagerRepository.findAll();
		assertThat(retrievedFromDb).hasSize(2);
	}
	
	@Test
	public void testSave() {
		TicketmanagerEntity mockTicket = getMockTicket1();
		TicketmanagerEntity savedinDb = ticketmanagerRepository.save(mockTicket);
		TicketmanagerEntity retrievedFromDB = testEntityManager.persist(mockTicket);
		assertThat(retrievedFromDB).isEqualTo(savedinDb);
		
	}
	
	@Test
	public void TestfindOne() {
		TicketmanagerEntity ticketmanagerEntity1 = getMockTicket1();
		TicketmanagerEntity ticketmanagerEntity2 = getMockTicket2();
		TicketmanagerEntity savedInDb1 = testEntityManager.persist(ticketmanagerEntity1);
		TicketmanagerEntity savedInDb2 = testEntityManager.persist(ticketmanagerEntity2);
		
		TicketmanagerEntity retrievedFromDb = ticketmanagerRepository.findOne(savedInDb1.getTicketId());
		assertThat(retrievedFromDb).isEqualTo(savedInDb1);
		
	}
	
	@Test
	public void testDelete()
	{
		TicketmanagerEntity ticketmanagerEntity1 = getMockTicket1();
		TicketmanagerEntity ticketmanagerEntity2 = getMockTicket2();
		TicketmanagerEntity savedInDb1 = testEntityManager.persist(ticketmanagerEntity1);
		TicketmanagerEntity savedInDb = testEntityManager.persist(ticketmanagerEntity2);
		ticketmanagerRepository.delete(savedInDb1.getTicketId());
		Iterable<TicketmanagerEntity> retrievedData = ticketmanagerRepository.findAll();
		assertThat(retrievedData).hasSize(1);
	}
	
	@Test
	public void testFindByPassengerNameAndFareAllIgnoreCase() {
		TicketmanagerEntity ticketmanagerEntity1 = getMockTicket1();
		TicketmanagerEntity ticketmanagerEntity2 = getMockTicket2();
		TicketmanagerEntity savedInDb1 = testEntityManager.persist(ticketmanagerEntity1);
		TicketmanagerEntity savedInDb = testEntityManager.persist(ticketmanagerEntity2);
		Iterable<TicketmanagerEntity> retrievedData = ticketmanagerRepository.findByPassengerNameAndFareAllIgnoreCase("sidDHarth", 100);
		assertThat(retrievedData).hasSize(1);
	}
	
	@Test
	public void testfindOneByPassengerName() {
		TicketmanagerEntity ticketmanagerEntity1 = getMockTicket1();
		TicketmanagerEntity ticketmanagerEntity2 = getMockTicket2();
		TicketmanagerEntity savedInDb1 = testEntityManager.persist(ticketmanagerEntity1);
		TicketmanagerEntity savedInDb = testEntityManager.persist(ticketmanagerEntity2);
		TicketmanagerEntity retrievedData = ticketmanagerRepository.findOneByPassengerName("Siddharth");
		assertThat(retrievedData.getFare()).isEqualTo(100);
	}
	
	
	public TicketmanagerEntity getMockTicket1() {
	TicketmanagerEntity mockTicketManagerEntity = new TicketmanagerEntity();
	mockTicketManagerEntity.setFare(100);
	mockTicketManagerEntity.setMailID("Sid@gmail.com");
	mockTicketManagerEntity.setPassengerName("Siddharth");
	return mockTicketManagerEntity;
	}

	public TicketmanagerEntity getMockTicket2() {
	TicketmanagerEntity mockTicketManagerEntity = new TicketmanagerEntity();
	mockTicketManagerEntity.setFare(100);
	mockTicketManagerEntity.setMailID("Sid@gmail.com");
	mockTicketManagerEntity.setPassengerName("Saheb");
	return mockTicketManagerEntity;
	
}	

}
