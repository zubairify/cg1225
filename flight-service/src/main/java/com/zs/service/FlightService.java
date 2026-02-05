package com.zs.service;

import java.util.List;

import com.zs.dto.FlightDTO;
import com.zs.entity.Flight;

public interface FlightService {
	
	Flight save(FlightDTO f);
	
	Flight find(int code);
	
	List<Flight> list();
	
	List<Flight> findByCarrier(String carrier);
	
	List<Flight> findByRoute(String src, String dest);
	
	static Flight transform(FlightDTO dto) {
		Flight f = new Flight();
		f.setCode(dto.getCode());
		f.setCarrier(dto.getCarrier());
		f.setSource(dto.getSource());
		f.setDestination(dto.getDestination());
		return f;
	}
}
