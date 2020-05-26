package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	// define field for entity manager
	private EntityManager entityManager;

	// set up constructor for injection
	@Autowired
	public EmployeeDAOImpl(EntityManager theentityManger) {
		entityManager = theentityManger;
	}

	@Override
	
	public List<Employee> findAll() {
	
		// create the query
		Query theQuery = entityManager.createQuery("from Employee");
		
		//excute query and get result list
		
		List<Employee> employees = theQuery.getResultList();
		
		//return the results
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		
		//get Employee
		
		Employee theEmployee = entityManager.find(Employee.class,theId); 
		
		
		return theEmployee;
	}

	@Override
	public void update(Employee theemployee) {
		
		//save or update the employee
		Employee dbEmployee = entityManager.merge(theemployee);
		
		//update with id from db .. sow e can get generated id for save/insert
		theemployee.setId(dbEmployee.getId());
		
		
	}

	@Override
	public void deleteById(int theId) {

		
		Employee theEmployee= entityManager.find(Employee.class,theId);
		 
		entityManager.remove(theEmployee);
		
	}

}
