package com.zs.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.zs.dao.StudentDao;
import com.zs.entity.Student;

public class TestStudentDao {

	private static StudentDao dao;
	
	@BeforeAll
	public static void init() {
		dao = new StudentDao();
	}
	
	@Test
	public void testSave() {
		Student s = new Student("Roy", "CS", 4.2);
		assertTrue(dao.save(s));
	}
	
	@Test
	public void testFind() {
		Student s = dao.find(1);
		assertNotNull(s);
		System.out.println(s);
	}
	
	@Test
	public void testList() {
		List<Student> students = dao.list();
		assertFalse(students.isEmpty());
		students.forEach(System.out::println);
	}
	
	@Test
	public void testListByBranch() {
		List<Student> students = dao.listByBranch("CS");
		assertFalse(students.isEmpty());
		students.forEach(System.out::println);
	}
}
