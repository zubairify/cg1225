package com.zs.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.zs.entity.Bus;
import com.zs.entity.Route;

public class RouteDao {
	private EntityManagerFactory emf;
	
	public RouteDao() {
		emf = Persistence.createEntityManagerFactory("MyJPA");
	}
	
	public boolean save(Route r) {
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		try {
			txn.begin();
			mgr.persist(r);
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
	
	public Route find(int rid) {
		EntityManager mgr = emf.createEntityManager();
		
		try {
			return mgr.find(Route.class, rid);
		} finally {
			mgr.close();
		}
	}
	
	public boolean addBusToRoute(int bid, int rid) {
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		try {
			txn.begin();
			Bus b = mgr.find(Bus.class, bid);
			Route r = mgr.find(Route.class, rid);
			r.getBusses().add(b);
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
