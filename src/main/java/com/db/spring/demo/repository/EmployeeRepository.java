package com.db.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.spring.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
