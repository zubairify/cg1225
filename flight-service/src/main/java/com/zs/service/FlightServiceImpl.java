package com.zs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.dto.FlightDTO;
import com.zs.entity.Flight;
import com.zs.error.FlightNotFoundException;
import com.zs.repo.FlightRepository;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository repo;
	
	@Transactional(value = TxType.REQUIRED)
	@Override
	public Flight save(FlightDTO f) {
		return repo.save(FlightService.transform(f));
	}

	@Override
	public Flight find(int code) {
		return repo.findById(code).orElseThrow(
				() -> new FlightNotFoundException("Invalid flight code: " + code));
	}

	@Override
	public List<Flight> list() {
		return repo.findAll();
	}

	@Override
	public List<Flight> findByCarrier(String carrier) {
		return repo.findByCarrier(carrier);
	}

	@Override
	public List<Flight> findByRoute(String src, String dest) {
		return repo.findByRoute(src, dest);
	}
}
