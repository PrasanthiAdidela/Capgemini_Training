package com.capgemini.emp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.emp.entities.Employee;

@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Optional<Employee> findByMobileNo(String mobileNo);

}
