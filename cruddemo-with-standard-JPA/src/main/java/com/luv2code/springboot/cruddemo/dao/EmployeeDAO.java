package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {

	
	public List<Employee> findAll();
	public Employee findById(int theId);
	public void update(Employee theemployee);
	public void deleteById(int theId);	
	
}
