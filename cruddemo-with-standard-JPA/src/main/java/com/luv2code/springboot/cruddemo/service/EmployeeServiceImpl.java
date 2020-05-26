package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	// constructor injection of DAO class 
	private EmployeeDAO employeeDAO;
	 
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	} 
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findId(int theId) {
		
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void update(Employee theemployee) {
		
		employeeDAO.update(theemployee);

	}

	@Override
	@Transactional
	public void delete(int theId) {
		
		employeeDAO.deleteById(theId);
		
	}

}
