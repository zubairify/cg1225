package com.zs.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.zs.entity.Customer;

public class CustomerDao {

	private EntityManagerFactory emf;
	
	public CustomerDao() {
		emf = Persistence.createEntityManagerFactory("MyJPA");
	}
	
	public boolean save(Customer c) {
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		try {
			txn.begin();
			mgr.persist(c);
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
	
	public Customer find(int cid) {
		EntityManager mgr = emf.createEntityManager();
		try {
			return mgr.find(Customer.class, cid);
		} finally {
			mgr.close();
		}
	}
	
	public boolean delete(int cid) {
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		try {
			txn.begin();
			Customer c = mgr.find(Customer.class, cid);
			mgr.remove(c);
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
	
	public List<Customer> list() {
		EntityManager mgr = emf.createEntityManager();
		
//		Query query = mgr.createQuery("FROM Customer");
		Query query = mgr.createNamedQuery("allCust");
		return query.getResultList();
	}
	
	public List<Customer> startWithE() {
		EntityManager mgr = emf.createEntityManager();
		
		Query query = mgr.createNamedQuery("enames");
		return query.getResultList();
	}
}

