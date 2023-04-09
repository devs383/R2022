package com.java.stream23;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterAndForeach {
	
	public static void main(String[] args) {
		//---------------------
		List<Integer> numbers=getNumbers();
		
		numbers.stream().filter(i->i>3).forEach(System.out::println);
		
		//------------------
		List<Employee> employees=getEmployees();
		
		employees.stream().filter(e->e.getSalary()>50000)
		.map(Employee::getSalary)
		.forEach(System.out::println);
		
		
		//-------------------
		Map<Integer,String> map=getMap();
		map.forEach((k,v)->System.out.println(k+":"+v));
		
		map.entrySet().stream().filter(e->e.getKey()>1).forEach(System.out::println);
		
		map.entrySet().stream().filter(e->e.getKey()>1).map(e->e.getValue()).forEach(System.out::println);

		
		
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
    
    public static Map<Integer,String> getMap(){
    	
    	Map<Integer, String> map=new HashMap<Integer, String>();
    	map.put(1, "a");
    	map.put(2, "b");
    	map.put(3, "c");
    	
    	return map;

    }

}
