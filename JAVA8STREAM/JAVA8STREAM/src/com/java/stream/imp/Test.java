package com.java.stream.imp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

	private static List<Employee> populateList(){
		
		List<Employee> employes=new ArrayList<Employee>();
		employes.add(new Employee("D", 10));

		employes.add(new Employee("A", 10));
		employes.add(new Employee("A", 12));
		employes.add(new Employee("A", 11));
		
		return employes;

	}
	
	public static void main(String[] args) {
		
		List<Employee> empList=populateList();
		
		Map<Integer,List<Employee>> map=empList.stream().collect(Collectors.groupingBy(Employee::getAge,Collectors.toList()));
	    map.entrySet().forEach(System.out::println);
	    
	    
	    Map<Integer,Long> map2=empList.stream().collect(Collectors.groupingBy(Employee::getAge,Collectors.counting()));
	    map2.entrySet().forEach(System.out::println);
	    
	   Map<Integer, List<Employee>> treeMap= empList.stream().collect(Collectors.groupingBy(Employee::getAge,TreeMap::new,Collectors.toList()));
	   System.out.println(treeMap);
	   
	   Map<String, Object> treeMap1= empList.stream().collect(Collectors.groupingBy(Employee::getName,TreeMap::new,Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getAge)), Optional::get)));

	   System.out.println(treeMap1);
	}
}
