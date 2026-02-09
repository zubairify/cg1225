package com.zs.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.zs.entity.Flight;
import com.zs.repo.FlightRepository;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestFlightRepository {

	@Autowired
	private FlightRepository repo;
	
	@Test
	@Order(1)
	public void testSave() {
		Flight f = new Flight();
		f.setCode(3012);
		f.setCarrier("SpiceJet");
		f.setSource("Mumbai");
		f.setDestination("Goa");
		
		Flight savedFlight = repo.save(f);
		assertNotNull(savedFlight);
	}
	
	@Test
	@Order(2)
	public void testFind() {
		Optional<Flight> f = repo.findById(3012);
		assertTrue(f.isPresent());
	}
	
	@Test
    @Order(3)
    public void testFindAll() {
        List<Flight> flights = repo.findAll();
        assertTrue(flights.size() > 0);
    }
	
	@Test
    @Order(4)
    public void testFindByCarrier() {
        List<Flight> flights = repo.findByCarrier("Indigo");
        assertTrue(flights.size() > 0);
    }
	
	@Test
    @Order(5)
    public void testFindByRoute() {
        List<Flight> flights = repo.findByRoute("Mumbai", "Chennai");
        assertTrue(flights.size() > 0);
    }
	
	
}
