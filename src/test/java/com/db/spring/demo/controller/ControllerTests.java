package com.db.spring.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.db.spring.demo.service.EmployeeService;

@ExtendWith(SpringExtension.class)
@WebMvcTest({ EmployeeController.class, Hello.class })
public class ControllerTests {

	private static Logger LOG = LoggerFactory.getLogger(ControllerTests.class);

	@MockBean
	EmployeeService employeeService;

	@Autowired
	MockMvc mockMvc;

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
		mockMvc.perform(get("/Employee")).andExpect(status().isOk());
	}

	@Test
	public void testGetEmployeeById() throws Exception {
		LOG.info("testGetEmployeeById using andExpect()");
		mockMvc.perform(get("/Employee/101")).andExpect(status().isOk());
	}
}