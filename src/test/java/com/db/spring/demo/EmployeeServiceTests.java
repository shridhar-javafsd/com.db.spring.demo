package com.db.spring.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.db.spring.demo.model.Employee;
import com.db.spring.demo.service.EmployeeService;

@SpringBootTest
public class EmployeeServiceTests {

	@Autowired
	EmployeeService service;

	@Test
	public void testGetEmployeeById() {
		Employee expected = new Employee(101, "Sonu", 10.5);
		Employee actual = service.getEmployeeById(101);
		assertEquals(expected, actual);
	}

}
