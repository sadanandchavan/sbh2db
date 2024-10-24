package com.sbh2db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbh2db.dto.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
