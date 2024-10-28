package com.sbh2db.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
		logger.info("Request for get employee by id");
		/*
		 * Employee employee = new Employee(); employee.setId(100);
		 * employee.setName("MahesBabu"); employee.setAddress("AP");
		 */
		Employee employee = employeeService.getEmployee(Long.parseLong(empId));
		return employee;

	}

	//http://localhost:8080/v1/employee {   "id": 101,   "name": "MahesBabu",   "address": "AP" }
	@PostMapping("/employee")
	public void saveEmployee(@RequestBody Employee employee) {
		logger.info("Request for save employee");
		employeeService.addEmployee(employee);

	}

	@GetMapping("/employeelist")
	public List <Employee> getAllEmployees() {
		logger.info("Request for get all employee");
		return	employeeService.getAllEmployee();
	}

	@DeleteMapping("/employee")
	public Employee deleteEmployeeDetails(@RequestParam String empId) {
		logger.info("Request for delete employee");
		Employee employee = employeeService.deleteEmployee(Long.parseLong(empId));
		return employee;

	}


}
