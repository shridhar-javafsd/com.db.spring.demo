package com.db.spring.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.db.spring.demo.controller.EmployeeController;

@SpringBootTest
class ApplicationTests {

	@Autowired
	EmployeeController employeeController;

	@Test
	public void contextLoads() throws Exception {
		Assertions.assertThat(employeeController).isExactlyInstanceOf(EmployeeController.class);
	}
}
