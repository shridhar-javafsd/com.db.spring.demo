package com.db.spring.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.db.spring.demo.model.Employee;
import com.db.spring.demo.service.EmployeeService;

@ExtendWith(SpringExtension.class)
@WebMvcTest({ EmployeeController.class, Hello.class })
public class ControllerTests {

	private static Logger LOG = LoggerFactory.getLogger(ControllerTests.class);

	@MockBean
	EmployeeService employeeService;

	@Autowired
	MockMvc mockMvc;

	public static List<Employee> empList;

	@BeforeAll
	public static void createEmpData() {
		empList = new ArrayList<>();
		empList.add(new Employee(101, "Sonu", 10.5));
		empList.add(new Employee(102, "Monu", 20.5));
		empList.add(new Employee(103, "Tonu", 15.5));
		LOG.info(empList.toString());
	}

	@Test
	public void testHello() throws Exception {
		LOG.info("testHello using assertEquals()");

		MvcResult mvcResult = mockMvc.perform(get("/hello")).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals("Hello world!", mvcResult.getResponse().getContentAsString());

	}

	@Test
	public void testGetAllEmployee() throws Exception {
		LOG.info("testGetAllEmployee using andExpect()");

		Mockito.when(employeeService.getAllEmployee()).thenReturn(empList);

		mockMvc.perform(get("/Employee")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(3)))
				.andExpect(jsonPath("$[*].id", Matchers.containsInAnyOrder(101, 102, 103)));
	}

	@Test
	public void testGetEmployeeById() throws Exception {
		LOG.info("testGetEmployeeById using andExpect()");

		Mockito.when(employeeService.getEmployeeById(101)).thenReturn(empList.get(0));

		mockMvc.perform(get("/Employee/101")).andExpect(status().isOk()).andExpect(jsonPath("$.id", Matchers.is(101)))
				.andExpect(jsonPath("$.name", Matchers.is("Sonu"))).andExpect(jsonPath("$.salary", Matchers.is(10.5)));
	}

	@AfterAll
	public static void nullifyEmpData() {
		LOG.info("nullifyEmpData");
		empList = null;
	}

}
