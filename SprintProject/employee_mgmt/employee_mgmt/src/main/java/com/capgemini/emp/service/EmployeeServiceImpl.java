package com.capgemini.emp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.capgemini.emp.dto.EmployeeDto;
import com.capgemini.emp.entities.Employee;
import com.capgemini.emp.exceptions.IdNotFoundException;
import com.capgemini.emp.exceptions.MobileNumberAlreadyExistsException;
import com.capgemini.emp.mappers.EmployeeMapper;
import com.capgemini.emp.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository empRepository;

	@Override
	public void addEmployee(EmployeeDto employeeDto) {
		String mobileNo=employeeDto.getMobileNo();
		Optional<Employee> opt=empRepository.findByMobileNo(mobileNo);
		if(opt.isPresent()) {
			throw new MobileNumberAlreadyExistsException("Employee with mobile number \""+mobileNo+"\" already exists");
		}
		Employee emp=EmployeeMapper.MapToEmployee(new Employee(), employeeDto);
		empRepository.save(emp);
		
	}

	@Override
	public List<EmployeeDto> allEmployees() {
		List<Employee> allEmp=empRepository.findAll();
		List<EmployeeDto> allDtos=new ArrayList<>();
		for(Employee emp:allEmp) {
			EmployeeDto dto=EmployeeMapper.MapToEmployeeDto(emp, new EmployeeDto());
			allDtos.add(dto);
		}
		return allDtos;
	}

	@Override
	public EmployeeDto getById(Integer empId) {
		Optional<Employee> opt=empRepository.findById(empId);
		if(opt.isPresent()) {
			EmployeeDto empDto=EmployeeMapper.MapToEmployeeDto(opt.get(), new EmployeeDto());
			return empDto;
		}
		throw new IdNotFoundException("Id not found"+empId);
	}

	@Override
	public void deleteEmployeeById(Integer empId) {
		Optional<Employee> opt=empRepository.findById(empId);
		if(opt.isPresent()) {
			empRepository.deleteById(empId);
			return;
		}
		throw new IdNotFoundException("Id not found"+empId);
	}

	@Override
	public EmployeeDto updateDetails(Integer empId, EmployeeDto empDto) {
		Optional<Employee> opt=empRepository.findById(empId);
		if(opt.isPresent()) {
			Employee employee=opt.get();
			employee.setEmployeeName(empDto.getEmployeeName());
			employee.setEmployeeAge(empDto.getEmployeeAge());
			employee.setMobileNo(empDto.getMobileNo());
			employee.setSalary(empDto.getSalary());
			Employee updated=empRepository.save(employee);
			return EmployeeMapper.MapToEmployeeDto(updated, new EmployeeDto());
		}
		throw new IdNotFoundException("Id not found"+empId);
	}

}
