package com.sbh2db.service;

import java.util.List;
import java.util.Optional;

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
	
	public Employee getEmployee(long empId) {
		Optional<Employee> opt = employeeRepository.findById(empId);
		return opt.get();
	}

	public List<Employee> getAllEmployee() {
		 return  employeeRepository.findAll();
	}

	public Employee deleteEmployee(Long empId) {
		employeeRepository.deleteById(empId);
		return null;
	}
}
