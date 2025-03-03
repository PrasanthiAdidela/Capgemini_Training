package com.capgemini.emp.service;

import java.util.List;

import com.capgemini.emp.dto.EmployeeDto;

public interface EmployeeService {

	void addEmployee(EmployeeDto employeeDto);

	List<EmployeeDto> allEmployees();

	EmployeeDto getById(Integer empId);

	void deleteEmployeeById(Integer empId);

	EmployeeDto updateDetails(Integer empId, EmployeeDto empDto);

}
