package com.db.spring.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.spring.demo.model.Employee;
import com.db.spring.demo.repository.EmployeeRepository;

//defining the business logic
@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

//getting all Employee record by using the method findaAll() of CrudRepository
	public List<Employee> getAllEmployee() {
		List<Employee> employee = new ArrayList<Employee>();
		employeeRepository.findAll().forEach(employee1 -> employee.add(employee1));
		return employee;
	}

//getting a specific record by using the method findById() of CrudRepository
	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).get();
	}

//saving a specific record by using the method save() of CrudRepository
	public void saveOrUpdate(Employee employee) {
		employeeRepository.save(employee);
	}

//deleting a specific record by using the method deleteById() of CrudRepository
	public void delete(int id) {
		employeeRepository.deleteById(id);
	}

//updating a record
	public void update(Employee employee, int eid) {
		employeeRepository.save(employee);
	}
}
