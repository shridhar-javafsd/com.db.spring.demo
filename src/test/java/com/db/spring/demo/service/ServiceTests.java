package com.db.spring.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.db.spring.demo.model.Employee;
import com.db.spring.demo.repository.EmployeeRepository;

/**
 * 
 * @author Vaman Deshmukh
 *
 */

@ExtendWith(MockitoExtension.class)
public class ServiceTests {

	@InjectMocks
	EmployeeService service;

	@Mock
	EmployeeRepository repository;

	public static List<Employee> empList;

	@BeforeAll
	public static void createEmpData() {

		empList = new ArrayList<>();
		empList.add(new Employee(101, "Sonu", 10.5));
		empList.add(new Employee(102, "Monu", 20.5));
		empList.add(new Employee(103, "Tonu", 15.5));
	}

	// @BeforeEach ---

	@Test
	public void testFindAllEmployees() {

		when(repository.findAll()).thenReturn(empList);

		List<Employee> empList2 = service.getAllEmployee();

		assertEquals(3, empList2.size());

		verify(repository, times(1)).findAll();
	}

//	@Test
//	public void testFindEmployeeById() {
//		when(repository.findById(101).get()).thenReturn(empList.get(0));
//		Employee emp = service.getEmployeeById(101);
//		System.out.println(emp.toString());
//		assertEquals("Sonu", emp.getName());
//		verify(repository, times(1)).findById(101);
//	}

	@Test
	public void testrSaveOrUpdate() {
		service.saveOrUpdate(empList.get(2));
		verify(repository, times(1)).save(empList.get(2));
	}

	@AfterAll
	public static void nullifyEmpData() {
		empList = null;
	}
}