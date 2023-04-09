package com.java.stream23;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StatisiticsExamples {
	
	
	public static void main(String[] args) {
		
		List<Double> employees=getEmployees().stream().map(Employee::getSalary).collect(Collectors.toList());
		
		DoubleSummaryStatistics summaryStatistics=employees.stream().mapToDouble(i->i).summaryStatistics();
		System.out.println("maxSal:"+summaryStatistics.getMax());
		System.out.println("minSal:"+summaryStatistics.getMin());
		System.out.println("avgSal:"+summaryStatistics.getAverage());
		System.out.println("sumSal:"+summaryStatistics.getSum());
		System.out.println("countSal:"+summaryStatistics.getCount());

	}
	
	public static List<Employee> getEmployees() {

		return Stream
				.of(new Employee("102", "dev", "PRODUCTION", Arrays.asList("6350233872", "6350233873"),
						Arrays.asList("devs383@gmil.com", "devrath92sharma@gmail.com"), 50000),
						new Employee("103", "rahul", "PRODUCTION", Arrays.asList("7350233872", "7350233873"),
								Arrays.asList("fevs383@gmil.com", "eevrath92sharma@gmail.com"), 60000),
						new Employee("101", "aarav", "PRODUCTION", Arrays.asList("8350233872", "8350233873"),
								Arrays.asList("fvs383@gmil.com", "fevrath92sharma@gmail.com"), 70000))
				.collect(Collectors.toList());

	}

}
