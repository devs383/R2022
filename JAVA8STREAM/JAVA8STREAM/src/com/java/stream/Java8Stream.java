package com.java.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;


public class Java8Stream {

	public static void main(String[] args) {
		
		List<Employee> empList=new ArrayList<>();
		empList.add(new Employee(101, "dev", 101, "active", 2000));
		empList.add(new Employee(102, "rah", 102, "inactive", 3000));
		empList.add(new Employee(103, "prav", 101, "inactive", 4000));
		empList.add(new Employee(104, "push", 102, "active", 5000));
		empList.add(new Employee(105, "push", 101, "inactive", 6000));

		//print employee details based on deptId
		Map<Integer, List<Employee>> empListBasedOnDept=empList.stream().collect(Collectors.groupingBy(Employee::getDeptId,Collectors.toList()));

		empListBasedOnDept.entrySet().forEach(entry->{
		System.out.println(entry.getKey()+"--"+entry.getValue());
		});
		
		
		//print employee count based on deptId
		
		Map<Integer, Long> countOfEmpOnDept=empList.stream().collect(Collectors.groupingBy(Employee::getDeptId,Collectors.counting()));
		
		countOfEmpOnDept.entrySet().forEach(entry->{
			
			System.out.println(entry.getKey()+":"+entry.getValue());
			
		});
		
		//print active and inactive employee count
		Long active=empList.stream().filter(emp->"active".equals(emp.getEmpStatus())).count();
		Long inactive=empList.stream().filter(emp->"inactive".equals(emp.getEmpStatus())).count();
		
		System.out.println("active employee count :"+active);
		System.out.println("inactive employee count :"+inactive);
		
		
		//print max and min employee salary
		
		Optional<Employee> emp1=empList.stream().max(Comparator.comparing(Employee::getSal));
		Optional<Employee> emp2=empList.stream().min(Comparator.comparing(Employee::getSal));

		System.out.println(emp1);
		System.out.println(emp2);
		
		
		
		//print max salary in each department
		Map<Integer, Optional<Employee>> maxSalaryOfEmpDept=empList.stream().collect(Collectors.groupingBy(Employee::getDeptId,
				
				Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSal)))
				
				));
		
		maxSalaryOfEmpDept.entrySet().forEach(entry->{
			
			
			System.out.println(entry.getKey()+"----"+entry.getValue());
			
		});
		
	}
	
}
