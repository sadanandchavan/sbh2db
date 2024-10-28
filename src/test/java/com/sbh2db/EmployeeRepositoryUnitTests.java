package com.sbh2db;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.sbh2db.dto.Employee;
import com.sbh2db.repository.EmployeeRepository;

@SpringBootTest
public class EmployeeRepositoryUnitTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	@DisplayName("Test 1 : Save Employee Test")
	@Order(1)
	@Rollback(value = false)
	public void saveEmployeeTest(){

		Employee employee = new Employee(); 
		employee.setId(100);
		employee.setName("MahesBabu"); 
		employee.setAddress("AP");

		employeeRepository.save(employee);

		//Verify
		System.out.println("Save employee"+employee);
		Assertions.assertThat(employee.getId()).isEqualTo(100);
	}

	@Test
	@Order(2)
	@DisplayName("Test 2 : Get Employee Test")
	public void getEmployeeTest(){
		//Action
		Employee employee2 = employeeRepository.findById(Long.parseLong("100")).get();
		//Verify
		System.out.println("Get employee"+employee2);
		Assertions.assertThat(employee2.getId()).isEqualTo(100);
	}

	@Test
	@Order(3)
	@DisplayName("Test 3 : List Employee Test")
	public void getListOfEmployeesTest(){
		//Action
		List<Employee> employees = employeeRepository.findAll();
		//Verify
		System.out.println("List employee"+employees.get(0).getName());
		Assertions.assertThat(employees.size()).isGreaterThan(0);

	}

	@Test
	@Order(4)
	@DisplayName("Test 4 : Update Employee Test")
	@Rollback(value = false)
	public void updateEmployeeTest(){

		//Action
		Employee employee = employeeRepository.findById(Long.parseLong("100")).get();
		employee.setAddress("Mumbai");
		Employee employeeUpdated =  employeeRepository.save(employee);

		//Verify
		System.out.println("Update employee"+employeeUpdated);
		Assertions.assertThat(employeeUpdated.getAddress()).isEqualTo("Mumbai");

	}

	@Test
	@Order(5)
	@DisplayName("Test 5 : Delete Employee Test")
	@Rollback(value = false)
	public void deleteEmployeeTest(){
		//Action
		employeeRepository.deleteById(100L);
		Optional<Employee> employeeOptional = employeeRepository.findById(Long.parseLong("100"));
		System.out.println("Delete employee"+employeeOptional);
		//Verify
		Assertions.assertThat(employeeOptional).isEmpty();
	}


}
