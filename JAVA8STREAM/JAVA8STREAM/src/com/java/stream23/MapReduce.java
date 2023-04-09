package com.java.stream23;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapReduce {
	
	public static void main(String[] args) {
		List<Integer> numbers=getNumbers();
		
		//approach 1
		int sum=0;
		for (int integer : numbers) {
			sum=sum+integer;
		}
		System.out.println("sum:"+sum);
		
		//approach 2
		sum=numbers.stream().mapToInt(i->i).sum();
		System.out.println("sum:"+sum);
		
		//approach 3
		sum=numbers.stream().reduce(0, Integer::sum);
		System.out.println("sum:"+sum);
		sum=numbers.stream().reduce(0,(a,b)->a+b);
		System.out.println("sum:"+sum);
		
		int max=numbers.stream().reduce((a,b)->a>b?a:b).get();
		System.out.println("max:"+max);
		int max1=numbers.stream().reduce(Integer::max).get();
		System.out.println("max1:"+max1);
		
		int multiply=numbers.stream().reduce(1,(a,b)->a*b );
		System.out.println("multiply:"+multiply);
		int count=(int) numbers.stream().mapToInt(i->i).count();
		System.out.println("count:"+count);

		double avg=numbers.stream().mapToDouble(i->i).average().getAsDouble();
		System.out.println("avg:"+avg);
		double avg2=numbers.stream().mapToInt(i->i).average().getAsDouble();
		System.out.println("avg2:"+avg2);

		String maxLengthString=getStrings().stream().reduce((s1,s2)->s1.length()>s2.length()?s1:s2).get();

		System.out.println("maxLengthString:"+maxLengthString);
		
		
		//---------------------------
		List<Employee> employees=getEmployees();
		
		//maptoDouble and average() method 
		double avgSalary=employees.stream().filter(e->e.getDept().equals("DEVELPMENT"))
			.map(Employee::getSalary)
			.mapToDouble(i->i)
			.average()
			.getAsDouble();
		System.out.println("avgSalary:"+avgSalary);
		
		//reduce , method reference for max
		double maxSal=employees.stream()
				.map(Employee::getSalary)
				.mapToDouble(e->e)
				.reduce(Double::max).getAsDouble();
		System.out.println("maxSal:"+maxSal);
		
		//reduce ,lamba expression function for combining two values 
		double maxSal1=employees.stream()
				.map(Employee::getSalary)
				.mapToDouble(e->e)
				.reduce((a,b)->a>b?a:b).getAsDouble();
		System.out.println("maxSal1:"+maxSal1);
		
		//maptoDouble then max() 
		double maxSal2=employees.stream()
				.map(Employee::getSalary)
				.mapToDouble(e->e).max().getAsDouble();
		System.out.println("maxSal1:"+maxSal1);



	}
	
	public static List<Employee> getEmployees(){
		
		return Stream.of(new Employee("101", "dev", "DEVELPMENT", Arrays.asList("6350233872","6350233873"), Arrays.asList("devs383@gmil.com","devrath92sharma@gmail.com"),50000)
				,new Employee("102", "dev2", "DEVELPMENT", Arrays.asList("7350233872","7350233873"), Arrays.asList("fevs383@gmil.com","eevrath92sharma@gmail.com"),60000)
			    ,new Employee("103", "dev3", "TESTING", Arrays.asList("8350233872","8350233873"), Arrays.asList("fvs383@gmil.com","fevrath92sharma@gmail.com"),70000)
				).collect(Collectors.toList());
			
		}
	
	public static List<Integer> getNumbers(){
		
		return Stream.of(1,2,3,4,5,6).collect(Collectors.toList());
	}
	
    public static List<String> getStrings(){
		
		return Stream.of("java","hibernate","springmvc","springboot").collect(Collectors.toList());
	}

}


