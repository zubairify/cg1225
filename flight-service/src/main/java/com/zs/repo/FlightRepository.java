package com.zs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zs.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

	// SELECT f FROM Flight f WHERE f.carrier=:carrier
	List<Flight> findByCarrier(String carrier);
	
	// List<Flight> findBySourceAndDestination(String source, String destination);
	
	@Query("SELECT f FROM Flight f WHERE f.source=:src AND f.destination=:dest")
	List<Flight> findByRoute(String src, String dest);
}
