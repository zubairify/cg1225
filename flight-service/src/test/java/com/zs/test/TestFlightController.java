package com.zs.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zs.controller.FlightController;
import com.zs.dto.FlightDTO;
import com.zs.entity.Flight;
import com.zs.service.FlightService;

@WebMvcTest(FlightController.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestFlightController {

	@Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private FlightService service;

    @Autowired
    private ObjectMapper objectMapper;
    
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
	public void testSave() throws Exception {
		// precondition
        given(service.save(any(FlightDTO.class))).willReturn(f1);
        // action
        ResultActions response = mockMvc.perform(post("/v1/api/fligts/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)));
        // verify
        response.andExpect(status().isOk());
	}
	
	@Test @Order(2)
    public void testFindById() throws Exception {
        // precondition
        given(service.find(3022)).willReturn(f1);
        // action
        ResultActions response = mockMvc.perform(get("/v1/api/flights/{code}",  f1.getCode()));
        // verify
        response.andExpect(status().isFound());
    }
	
	@Test @Order(3)
    public void testFindAll() throws Exception {
        // precondition
        given(service.list()).willReturn(List.of(f1, f2));
        // action
        ResultActions response = mockMvc.perform(get("/v1/api/flights"));
        // verify
        response.andExpect(status().isOk());
    }
	
	@Test @Order(4)
    public void testFindByCarrier() throws Exception {
		// precondition
		given(service.findByCarrier("Spicejet")).willReturn(List.of(f1, f2));
		// action
		ResultActions response = mockMvc.perform(get("/v1/api/flights/carrier/Spicejet"));
        // verify
		response.andExpect(status().isOk());
	}
	
	@Test @Order(5)
    public void testFindByRoute() throws Exception {
		// precondition
		given(service.findByRoute("Mumbai", "Delhi")).willReturn(List.of(f1));
		// action
		ResultActions response = mockMvc.perform(get("/v1/api/flights/route?src=Mumbai&dest=Delhi"));
        // verify
		response.andExpect(status().isOk());
	}
}
