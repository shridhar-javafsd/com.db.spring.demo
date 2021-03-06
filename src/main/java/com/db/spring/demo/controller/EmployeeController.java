package com.db.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.db.spring.demo.model.Employee;
import com.db.spring.demo.service.EmployeeService;

/**
 * 
 * @author Vaman
 *
 */

//mark class as Controller
@RestController

public class EmployeeController {

	// autowire the EmployeeService class
	@Autowired
	EmployeeService employeeService;

//creating a get mapping that retrieves all the Employee detail from the database
//	@GetMapping("/Employee")
//	private List<Employee> getAllEmployee() {
//		return employeeService.getAllEmployee();
//	}

	@GetMapping("/Employee")
	private ResponseEntity<List<Employee>> getAllEmployee() {

		return new ResponseEntity<List<Employee>>(employeeService.getAllEmployee(), HttpStatus.OK);
		
	}

	/**
	 * creating a get mapping that retrieves the detail of a specific Employee
	 * 
	 * @param id value for employee id to find
	 * @return Employee object based on the input Employees id
	 */

	@GetMapping("/Employee/{id}")
	private Employee getEmployee(@PathVariable("id") int id) {
		return employeeService.getEmployeeById(id);
	}

//creating a delete mapping that deletes a specified Employee
	@DeleteMapping("/Employee/{id}")
	private void deleteEmployee(@PathVariable("id") int id) {
		employeeService.delete(id);
	}

//creating post mapping that post the Employee detail in the database
	@PostMapping("/Employee")
	private int saveEmployee(@RequestBody Employee employee) {
		employeeService.saveOrUpdate(employee);
		return employee.getId();
	}

//creating put mapping that updates the Employee detail
	@PutMapping("/Employee")
	private Employee update(@RequestBody Employee Employee) {
		employeeService.saveOrUpdate(Employee);
		return Employee;
	}
}
