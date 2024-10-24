package com.sbh2db.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sbh2db.dto.Employee;
import com.sbh2db.service.EmployeeService;

@RequestMapping("/v1")
@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	private static Logger logger = LogManager.getLogger(RestController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	//http://localhost:8080/v1/employee?empId=100
	@GetMapping("/employee")
	public Employee getEmployeeDetails(@RequestParam String empId) {
		logger.info("Request for get employee");
		Employee employee = new Employee();
		employee.setId(100);
		employee.setName("MahesBabu");
		employee.setAddress("AP");
		
		return employee;
		
	}
	
	//http://localhost:8080/v1/employee {   "id": 101,   "name": "MahesBabu",   "address": "AP" }
	@PostMapping("/employee")
	public void saveEmployee(@RequestBody Employee employee) {
		logger.info("Request for save employee");
		employeeService.addEmployee(employee);
		
	}

}
