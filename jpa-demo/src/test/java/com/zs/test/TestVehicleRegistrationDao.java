package com.zs.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.zs.dao.VehicleRegistrationDao;

public class TestVehicleRegistrationDao {
	private static VehicleRegistrationDao dao;
	
	@BeforeAll
	public static void init() {
		dao = new VehicleRegistrationDao();
	}
	
	@Test
	public void testSaveRegistration() {
	}
	
	@Test
	public void testSaveVehicle() {
	}
	
	@Test
	public void testFindRegistration() {
	}
	
	@Test
	public void testFindVehicle() {
	}
}
