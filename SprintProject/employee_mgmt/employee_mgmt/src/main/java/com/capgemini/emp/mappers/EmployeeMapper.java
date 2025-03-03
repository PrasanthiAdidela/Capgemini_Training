package com.capgemini.emp.mappers;

import com.capgemini.emp.dto.EmployeeDto;
import com.capgemini.emp.entities.Employee;

public class EmployeeMapper {
	
	public static Employee MapToEmployee(Employee employee, EmployeeDto employeeDto) {
		employee.setEmployeeName(employeeDto.getEmployeeName());
		employee.setMobileNo(employeeDto.getMobileNo());
		employee.setEmployeeAge(employeeDto.getEmployeeAge());
		employee.setEmployeeId(employeeDto.getEmployeeId());
		employee.setSalary(employeeDto.getSalary());
		return employee;
	}
	
	public static EmployeeDto MapToEmployeeDto(Employee employee, EmployeeDto employeeDto) {
		employeeDto.setEmployeeName(employee.getEmployeeName());
		employeeDto.setMobileNo(employee.getMobileNo());
		employeeDto.setEmployeeAge(employee.getEmployeeAge());
		employeeDto.setEmployeeId(employee.getEmployeeId());
		employeeDto.setSalary(employee.getSalary());
		return employeeDto;
	}

}
