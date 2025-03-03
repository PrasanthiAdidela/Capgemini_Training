package com.capgemini.emp.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.emp.dto.EmployeeDto;
import com.capgemini.emp.service.EmployeeService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path="/api")
public class EmployeeController {
	
	private EmployeeService empService;
	
	@PostMapping(path="/newEmployee")
	public ResponseEntity<?> addNewEmployee(@Valid @RequestBody EmployeeDto employeeDto){
		empService.addEmployee(employeeDto);
		return new ResponseEntity<String>("Created Successfully",HttpStatus.CREATED);
	}
	
	@GetMapping(path="/allEmployees")
	public ResponseEntity<?> getAllEmployees(){
		List<EmployeeDto> allEmployees=empService.allEmployees();
		return new ResponseEntity<List<EmployeeDto>>(allEmployees,HttpStatus.OK);
	}
	
	@GetMapping(path="/emp/{empId}")
	public ResponseEntity<?> employeeById(@PathVariable Integer empId){
		EmployeeDto employee=empService.getById(empId);
		return new ResponseEntity<EmployeeDto>(employee,HttpStatus.OK);
	}
	
	@DeleteMapping(path="/emp/{empId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Integer empId){
		empService.deleteEmployeeById(empId);
		return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
	}
	
	@PutMapping(path="/emp/{empId}")
	public ResponseEntity<?> updateEmployeeDetails(@RequestBody EmployeeDto empDto,@PathVariable Integer empId){
		EmployeeDto employee=empService.updateDetails(empId,empDto);
		return new ResponseEntity<EmployeeDto>(employee,HttpStatus.OK);
	}

}
