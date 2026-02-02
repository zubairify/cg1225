package com.zs.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.zs.entity.Bus;

public class BusDao {
	private EntityManagerFactory emf;
	
	public BusDao() {
		emf = Persistence.createEntityManagerFactory("MyJPA");
	}
	
	public boolean save(Bus b) {
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		try {
			txn.begin();
			mgr.persist(b);
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
	
	public Bus find(int bid) {
		EntityManager mgr = emf.createEntityManager();
		
		try {
			return mgr.find(Bus.class, bid);
		} finally {
			mgr.close();
		}
	}
}
