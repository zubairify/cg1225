package com.zs.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.zs.entity.Passenger;
import com.zs.entity.Route;

public class PassengerDao {
	private EntityManagerFactory emf;
	
	public PassengerDao() {
		emf = Persistence.createEntityManagerFactory("MyJPA");
	}
	
	public boolean save(Passenger p, int rid) {
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		try {
			txn.begin();
			Route r = mgr.find(Route.class, rid);
			p.setRoute(r);
			mgr.persist(p);
			txn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
			return false;
		} finally {
			mgr.close();
		}
	}
}
