package employeemanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {
	
	private Integer empId;
	private String empName;
	private float empSal;
	
  
 public Integer getEmpId() {
		return empId;
	}



	public void setEmpId(Integer empId) {
		this.empId = empId;
	}



	public String getEmpName() {
		return empName;
	}



	public void setEmpName(String empName) {
		this.empName = empName;
	}



	public float getEmpSal() {
		return empSal;
	}



	public void setEmpSal(float empSal) {
		this.empSal = empSal;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + "]";
	}



	public static void main(String[]args) {
		
		Employee emp1=new Employee();
		emp1.setEmpId(1);
		emp1.setEmpName("Prashanthi");
		emp1.setEmpSal(25953);
		
		Employee emp2=new Employee();
		emp2.setEmpId(2);
		emp2.setEmpName("Sujith");
		emp2.setEmpSal(25952);
		
		Employee emp3=new Employee();
		emp3.setEmpId(3);
		emp3.setEmpName("Harsha");
		emp3.setEmpSal(2000);
		
		List<Employee>list=new ArrayList<>();
		list.add(emp3);
		list.add(emp2);
		list.add(emp1);
		
		System.out.println(list);
		
		List<Employee> highSalaryEmployees = list.stream()
		        .filter(e -> e.getEmpSal() > 6000)
		        .collect(Collectors.toList());
		
		System.out.println(highSalaryEmployees);
		
		List<Employee> sortedBySalary = list.stream()
		        .sorted((e1, e2) -> {
		        	if(e1.getEmpSal()>e2.getEmpSal()) {
		        		return 1;
		        	}return -1;
		        })
		        .collect(Collectors.toList());
		
		
		System.out.println(sortedBySalary);
		
		String allEmployeeNames = list.stream()
		        .map(Employee::getEmpName)
		        .collect(Collectors.joining(", "));
		System.out.println(allEmployeeNames);
		 
	 }
}


	


