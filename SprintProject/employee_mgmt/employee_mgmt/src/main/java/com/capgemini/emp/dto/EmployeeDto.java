package com.capgemini.emp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmployeeDto {
	
	private Integer employeeId;
	
	@NotBlank(message = "Employee Name should not be blank")
	private String employeeName;
	
	@NotNull(message = "Employee Age should not be null")
	private Integer employeeAge;
	
	@NotNull(message = "Employee Salary should not be null")
	private Float salary;
	
	@NotBlank(message = "Mobile Number should not be blank")
	@Size(min = 10,max = 10,message = "Mobile Number should contain 10 digits")
	@Pattern(regexp = "^[6-9][0-9]{9}", message = "Invalid Mobile Number")
	private String mobileNo;

}
