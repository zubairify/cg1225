package com.zs.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.zs.dao.EmpDeptDao;
import com.zs.entity.Department;
import com.zs.entity.Employee;

public class TestEmpDeptDao {
	
	private static EmpDeptDao dao;
	
	@BeforeAll
	public static void init() {
		dao = new EmpDeptDao();
	}

	@Test
	public void testSaveDept() {
		Department dept = new Department(10, "Sales", "Mumbai");
		assertTrue(dao.saveDept(dept));
	}
	
	@Test
	public void testSaveEmp() {
		Employee emp = new Employee(101, "Chris", 1900);
		assertTrue(dao.saveEmp(emp, 10));
	}
	
	@Test
	public void testFindDept() {
		Department dept = dao.findDept(10);
		assertNotNull(dept);
		System.out.println(dept);
		List<Employee> emps = dept.getEmps();
		emps.forEach(System.out::println);
	}
	
	@Test
	public void testFindEmp() {
		Employee emp = dao.findEmp(101);
		assertNotNull(emp);
		System.out.println(emp);
		System.out.println(emp.getDept());
	}
	
	@Test
	public void testDeleteDept() {
		assertTrue(dao.deleteDept(20));
	}
	
	@Test
	public void testDeleteEmp() {
		
	}
	
	@Test
	public void testUpdateLocation() {
		assertTrue(dao.updateLocation(20, "Chennai"));
	}
	
	@Test
	public void testUpdateSalary() {
		assertTrue(dao.updateSalary(101, 1800));
	}
}
