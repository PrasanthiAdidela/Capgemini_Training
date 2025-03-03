package com.capgemini.emp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Employee_Table")
public class Employee {
	
	@Id
	@Column(name = "employee_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeId;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "Age")
	private Integer employeeAge;
	
	@Column(name = "mobile_number")
	private String mobileNo;
	
	@Column(name = "Salary")
	private Float salary;

}
