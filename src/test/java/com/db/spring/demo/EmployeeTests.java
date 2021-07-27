package com.db.spring.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.db.spring.demo.model.Employee;

@SpringBootTest
public class EmployeeTests {

	@Test
	public void testEmp() {
		String expected = new Employee(101, "Sonu", 10.5).toString();
		String actual = new Employee(101, "Sonu", 10.5).toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testEmp2() {
		String unexpected = new Employee(101, "Sonu", 10.5).toString();
		String actual = new Employee(102, "Monu", 20.5).toString();
		assertNotEquals(unexpected, actual);
	}
}
