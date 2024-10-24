package com.sbh2db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbh2db.dto.Employee;
import com.sbh2db.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public void getEmployee(long empId) {
		employeeRepository.findById(empId);
		
	}
}
