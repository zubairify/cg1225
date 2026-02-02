package com.zs.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.zs.entity.Registration;
import com.zs.entity.Vehicle;

public class VehicleRegistrationDao {

	private EntityManagerFactory emf;
	
	public VehicleRegistrationDao() {
		emf = Persistence.createEntityManagerFactory("MyJPA");
	}
	
	public boolean saveRegistration(Registration reg) {
		return false;
	}
	
	public boolean saveVehicle(Vehicle v, String regNo) {
		return false;
	}
	
	public Vehicle findVehicle(int vid) {
		return null;
	}
	
	public Registration findRegistration(String regNo) {
		return null;
	}
}
