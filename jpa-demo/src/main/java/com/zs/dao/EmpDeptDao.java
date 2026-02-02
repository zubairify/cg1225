package com.zs.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.zs.entity.Department;
import com.zs.entity.Employee;

public class EmpDeptDao {
	private EntityManagerFactory emf;
	
	public EmpDeptDao() {
		emf = Persistence.createEntityManagerFactory("MyJPA");
	}
	
	public boolean saveDept(Department d) {
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		try {
			txn.begin();
			mgr.persist(d);
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
	
	public boolean saveEmp(Employee emp, int dno) {
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		try {
			txn.begin();
			Department d = mgr.find(Department.class, dno);
			emp.setDept(d);
			mgr.persist(emp);
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
	
	public Department findDept(int dno) {
		EntityManager mgr = emf.createEntityManager();
		try {
			Department dept = mgr.find(Department.class, dno);
			return dept;
		} finally {
			mgr.close();
		}
	}
	
	public Employee findEmp(int eno) {
		EntityManager mgr = emf.createEntityManager();
		try {
			Employee emp = mgr.find(Employee.class, eno);
			return emp;
		} finally {
			mgr.close();
		}
	}
	
	public boolean deleteDept(int dno) {
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		try {
			txn.begin();
			Department d = mgr.find(Department.class, dno);
			mgr.remove(d);
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
	
	public boolean deleteEmp(int eno) {
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		try {
			txn.begin();
			Employee emp = mgr.find(Employee.class, eno);
			mgr.remove(emp);
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
	
	public boolean updateLocation(int dno, String location) {
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		try {
			txn.begin();
			Department d = mgr.find(Department.class, dno);
			d.setLocation(location);
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
	
	public boolean updateSalary(int eno, double salary) {
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = null;
		try {
			Employee emp = mgr.find(Employee.class, eno);
			mgr.close();	// One session is closed
			// emp object is detached
			mgr = emf.createEntityManager(); // another session begins
			txn = mgr.getTransaction();
			txn.begin();
			emp.setSalary(salary);
			mgr.merge(emp);
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
