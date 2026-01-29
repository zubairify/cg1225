package com.zs.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.zs.entity.Student;

public class StudentDao {

	private EntityManagerFactory emf;
	
	public StudentDao() {
		emf = Persistence.createEntityManagerFactory("MyJPA");
	}
	
	public boolean save(Student s) {
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		try {
			txn.begin();
			mgr.persist(s);
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
	
	public Student find(int rno) {
		return emf.createEntityManager().find(Student.class, rno);
	}
	
	public boolean delete(int rno) {
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		try {
			txn.begin();
			Student s = mgr.find(Student.class, rno);
			mgr.remove(s);
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
	
	public List<Student> list() {
		EntityManager mgr = emf.createEntityManager();
		
		try {
			Query query = mgr.createNamedQuery("allStudents");
			return query.getResultList();
		} finally {
			mgr.close();
		}
	}
	
	public List<Student> listByBranch(String branch) {
		EntityManager mgr = emf.createEntityManager();
		
		try {
			Query query = mgr.createNamedQuery("byBranch");
			query.setParameter("br", branch);
			return query.getResultList();
		} finally {
			mgr.close();
		}
	}
}

