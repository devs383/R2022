package com.java.stream23;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapAndFlatMap {
	
	public static void main(String[] args) {
		
		//map(mapper function) transforming the data 
		//its mapper function take single input value and produce single output ,hence it is called one to one mapping 
		
		List<Employee> employees=getEmployees();
		List<String> employeesNames=employees.stream().map(Employee::getEmpName).collect(Collectors.toList());
		List<String> employeesNamesInUppercase=employees.stream().map(e->e.getEmpName().toUpperCase()).collect(Collectors.toList());
        List<List<String>> employeesPhones=employees.stream().map(Employee::getPhones).collect(Collectors.toList());
        
		System.out.println(employeesNames);
		System.out.println(employeesNamesInUppercase);
		System.out.println(employeesPhones);

		//employeesNames.forEach(System.out::println);
		
		//flatMap(its mapper function produce multiple value for single input,hence it is called one to many mapping )
		//transforming and flattring the data 
		//mapper function "e->e.getPhones().stream()"
		
		List<String> phones=employees.stream().flatMap(e->e.getPhones().stream()).collect(Collectors.toList());
		
		System.out.println(phones);

	}
	
	public static List<Employee> getEmployees(){
		
	return Stream.of(new Employee("101", "dev", "DEVELPMENT", Arrays.asList("6350233872","6350233873"), Arrays.asList("devs383@gmil.com","devrath92sharma@gmail.com"))
			,new Employee("102", "dev2", "PRODUCTION", Arrays.asList("7350233872","7350233873"), Arrays.asList("fevs383@gmil.com","eevrath92sharma@gmail.com"))
		    ,new Employee("103", "dev3", "TESTING", Arrays.asList("8350233872","8350233873"), Arrays.asList("fvs383@gmil.com","fevrath92sharma@gmail.com"))
			).collect(Collectors.toList());
		
	}

}

 
 class Employee{
	
	private String empId;
	private String empName;
	private String dept;
	private List<String> phones;
	private List<String> mails;
	private double Salary;
	
	
	
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", dept=" + dept + ", phones=" + phones
				+ ", mails=" + mails + ", Salary=" + Salary + "]";
	}
	public Employee() {
		super();
	}
	public Employee(String empId, String empName, String dept, List<String> phones, List<String> mails) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.dept = dept;
		this.phones = phones;
		this.mails = mails;
	}
	
	
	
	public Employee(String empId, String empName, String dept, List<String> phones, List<String> mails, double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.dept = dept;
		this.phones = phones;
		this.mails = mails;
		Salary = salary;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public List<String> getPhones() {
		return phones;
	}
	public void setPhones(List<String> phones) {
		this.phones = phones;
	}
	public List<String> getMails() {
		return mails;
	}
	public void setMails(List<String> mails) {
		this.mails = mails;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	
	
	
}
