package com.db.spring.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.spring.demo.model.Employee;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//mark class as Controller
@RestController
public class EmployeeController {
//autowire the EmployeeService class
	@Autowired
	EmployeeService employeeService;

//creating a get mapping that retrieves all the Employee detail from the database
	@GetMapping("/Employee")
	private List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

//creating a get mapping that retrieves the detail of a specific Employee
	@GetMapping("/Employee/{eid}")
	private Employee getEmployee(@PathVariable("eid") int eid) {
		return employeeService.getEmployeeById(eid);
	}

//creating a delete mapping that deletes a specified Employee
	@DeleteMapping("/Employee/{eid}")
	private void deleteEmployee(@PathVariable("eid") int eid) {
		employeeService.delete(eid);
	}

//creating post mapping that post the Employee detail in the database
	@PostMapping("/Employee")
	private int saveEmployee(@RequestBody Employee Employee) {
		employeeService.saveOrUpdate(Employee);
		return Employee.getEid();
	}

//creating put mapping that updates the Employee detail
	@PutMapping("/Employee")
	private Employee update(@RequestBody Employee Employee) {
		employeeService.saveOrUpdate(Employee);
		return Employee;
	}
}
