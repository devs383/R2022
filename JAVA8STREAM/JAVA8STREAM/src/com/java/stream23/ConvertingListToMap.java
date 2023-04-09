package com.java.stream23;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertingListToMap {
	
	public static void main(String[] args) {
		
		convertListOfEmployeeToMap();
		
		
	}

	private static void convertListOfEmployeeToMap() {
        
		List<Employee> employees=getEmployees();
		
		employees.stream().collect(Collectors.toMap(Employee::getDept, Employee::getEmpName))
		.forEach((e1,e2)->System.out.println(e1+":"+e2));
		
		employees.stream().collect(Collectors.toMap(Employee::getDept,Employee::getMails))
		.forEach((e1,e2)->System.out.println(e1+":"+e2));
		
		//resolving null pointer exception if employee has some null value
		
		//employees.stream().collect(HashMap::new ,(m,v)->m.)
	}

	public static List<Employee> getEmployees() {

		return Stream
				.of(new Employee("102", null, "DEVELOPMENT", Arrays.asList("6350233872", "6350233873"),
						Arrays.asList("devs383@gmil.com", "devrath92sharma@gmail.com"), 50000),
						new Employee("103", "rahul", "PRODUCTION", Arrays.asList("7350233872", "7350233873"),
								Arrays.asList("fevs383@gmil.com", "eevrath92sharma@gmail.com"), 60000),
						new Employee("101", "aarav", "TESTING", Arrays.asList("8350233872", "8350233873"),
								Arrays.asList("fvs383@gmil.com", "fevrath92sharma@gmail.com"), 70000))
				.collect(Collectors.toList());

	}

}
