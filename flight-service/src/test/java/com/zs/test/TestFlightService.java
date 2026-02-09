package com.zs.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.zs.dto.FlightDTO;
import com.zs.entity.Flight;
import com.zs.repo.FlightRepository;
import com.zs.service.FlightService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestFlightService {
	@Mock
	private FlightRepository repo;
	
	@InjectMocks
	private FlightService service;
	
	private FlightDTO dto;
	private Flight f1, f2;
	
	@BeforeEach
	public void setup() {
		dto = new FlightDTO();
		dto.setCode(3022);
		dto.setCarrier("SpiceJet");
		dto.setSource("Mumbai");
		dto.setDestination("Delhi");
		
		f1 = new Flight();
		f1.setCode(3022);
		f1.setCarrier("SpiceJet");
		f1.setSource("Mumbai");
		f1.setDestination("Delhi");
		
		f2 = new Flight();
		f2.setCode(3023);
		f2.setCarrier("SpiceJet");
		f2.setSource("Chennai");
		f2.setDestination("Delhi");
	}
	
	@Test @Order(1)
	public void testSave() {
		// precondition
        given(repo.save(f1)).willReturn(f1);
        // action
        Flight savedFlight = service.save(dto);
        // verify
        assertNotNull(savedFlight);
	}
	
	@Test @Order(2)
    public void testFindById() {
        // precondition
        given(repo.findById(3022)).willReturn(Optional.of(f1));
        // action
        Flight result = service.find(3022);
        // verify
        assertNotNull(result);
    }
	
	@Test @Order(3)
    public void testFindAll() {
        // precondition
        given(repo.findAll()).willReturn(List.of(f1, f2));
        // action
        List<Flight> flights = service.list();
        // verify
        assertEquals(2, flights.size());
    }
	
	@Test @Order(4)
    public void testFindByCarrier() {
		// precondition
		given(repo.findByCarrier("Spicejet")).willReturn(List.of(f1, f2));
		// action
        List<Flight> flights = service.findByCarrier("Spicejet");
        // verify
        assertEquals(2, flights.size());
	}
	
	@Test @Order(5)
    public void testFindByRoute() {
		// precondition
		given(repo.findByRoute("Mumbai", "Delhi")).willReturn(List.of(f1));
		// action
        List<Flight> flights = service.findByRoute("Mumbai", "Delhi");
        // verify
        assertEquals(1, flights.size());
	}
}
