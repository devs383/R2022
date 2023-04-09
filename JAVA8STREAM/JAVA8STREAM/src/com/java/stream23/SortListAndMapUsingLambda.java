package com.java.stream23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortListAndMapUsingLambda {

	public static void main(String[] args) {

		// sortNumbers();

		// sortStrings();

		// sortEmployees();
		
		//sortMap();
		
		sortMapOfEmployee();
	}
	
	public static void sortMapOfEmployee() {
		
		Map<Employee, Integer> mapOfEmployees=getMapOfEmployeeAskey();
		List<Entry<Employee, Integer>> entriesOfEmployees=new ArrayList<Entry<Employee, Integer>>(mapOfEmployees.entrySet());
		Collections.sort(entriesOfEmployees,
				
				Map.Entry.comparingByKey(Comparator.comparing(Employee::getEmpId).reversed())
				
				);
		
		System.out.println("entriesOfEmployees:"+entriesOfEmployees);
		
		List<Entry<Employee, Integer>> entriesOfEmployees1=new ArrayList<Entry<Employee, Integer>>(mapOfEmployees.entrySet());
		Collections.sort(entriesOfEmployees1,(e1,e2)->e2.getKey().getEmpName().compareTo(e1.getKey().getEmpName()));
		
		System.out.println("entriesOfEmployees1:"+entriesOfEmployees1);
		
		//Stream API
		List<Entry<Employee, Integer>> entriesOfEmployees2=new ArrayList<Entry<Employee, Integer>>(mapOfEmployees.entrySet());
		entriesOfEmployees2.stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getEmpId).reversed())).forEach(System.out::println);
		
		List<Entry<Employee, Integer>> entriesOfEmployees3=new ArrayList<Entry<Employee, Integer>>(mapOfEmployees.entrySet());
		entriesOfEmployees3.stream().sorted((e1,e2)->e2.getKey().getEmpId().compareTo(e1.getKey().getEmpId())).forEach(System.out::println);

		
	}

	public static void sortMap() {
		Map<String, Integer> map3 = getMap();
		List<Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(map3.entrySet());
		Collections.sort(entries, (e1, e2) -> e1.getKey().compareTo(e2.getKey()));
		System.out.println("entries" + entries);

		Map<String, Integer> map = getMap();
		List<Entry<String, Integer>> sortedlist = map.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toList());
		System.out.println(sortedlist);

		Map<String, Integer> map1 = getMap();
		List<Entry<String, Integer>> sortedlist1 = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toList());
		System.out.println(sortedlist1);
	}

	public static void sortEmployees() {

		Comparator<Employee> empComparator = new Comparator<Employee>() {

			@Override
			public int compare(Employee e1, Employee e2) {
				// TODO Auto-generated method stub
				return e1.getEmpName().compareTo(e2.getEmpName());
			}
		};
		List<Employee> employees = getEmployees();
		Collections.sort(employees, empComparator);
		// Collections.reverse(employees);
		System.out.println("employees:" + employees);

		// ------------------------------------------
		List<Employee> employees1 = getEmployees();
		Collections.sort(employees1, (e1, e2) -> e2.getEmpName().compareTo(e1.getEmpName()));
		System.out.println("employees1:" + employees1);

		List<Employee> employees2 = getEmployees();
		Collections.sort(employees2, Comparator.comparing(Employee::getEmpName).reversed());
		System.out.println("employees2:" + employees2);

		// Stream API
		List<Employee> employees3 = getEmployees();

		List<Employee> sortedEmployees3 = employees3.stream()
				.sorted((e1, e2) -> (int) (e2.getSalary() - e1.getSalary())).collect(Collectors.toList());
		System.out.println("sortedEmployees3:" + sortedEmployees3);
		System.out.println("---------------------------------");
		List<Employee> employees5 = getEmployees();

		employees5.stream().sorted((e1, e2) -> (int) (e2.getSalary() - e1.getSalary())).forEach(System.out::println);
		;
		System.out.println("---------------------------------");

		List<Employee> employees4 = getEmployees();
		List<Employee> sortedEmployees4 = employees4.stream()
				.sorted(Comparator.comparing(Employee::getEmpName).reversed()).collect(Collectors.toList());
		System.out.println("sortedEmployees4:" + sortedEmployees4);

	}

	public static void sortStrings() {

		List<String> strings = getStrings();

		Collections.sort(strings);
		System.out.println(strings);

		List<String> strings2 = getStrings();

		Collections.sort(strings2, Comparator.reverseOrder());
		System.out.println(strings2);

		List<String> strings3 = getStrings();
		Collections.sort(strings3);
		Collections.reverse(strings3);
		System.out.println(strings3);

		List<String> strings4 = getStrings();
		Collections.sort(strings4, (o1, o2) -> o2.toString().compareTo(o1.toString()));
		System.out.println(strings4);

		List<String> strings5 = getStrings();
		Collections.sort(strings5, (new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				return s2.compareTo(s1);
			}

		}));
		System.out.println(strings5);

		// Using Stream API
		List<String> strings6 = getStrings();

		List<String> sortedList = strings6.stream().sorted().collect(Collectors.toList());
		System.out.println("sortedList in assending order:" + sortedList);

		List<String> sortedList2 = strings6.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("sortedList2 in decending order:" + sortedList2);

		List<String> sortedList3 = strings6.stream().sorted((s1, s2) -> s2.compareTo(s1)).collect(Collectors.toList());
		System.out.println("sortedList3 in decending order:" + sortedList2);

	}

	public static void sortNumbers() {

		List<Integer> numbers = getNumbers();

		// Using collections utility class sort method
		// 1
		Collections.sort(numbers);
		System.out.println("sorted list in assendong order:" + numbers);

		// 2
		List<Integer> numbers1 = getNumbers();
		Collections.reverse(numbers);
		System.out.println("numbers1:" + numbers1);

		// 3
		Collections.sort(numbers, new Comparator<Integer>() {

			@Override
			public int compare(Integer i1, Integer i2) {
				// TODO Auto-generated method stub
				return i2 - i1;
			}

		});

		System.out.println("sorted list in decending  order:" + numbers);

		// 4
		Comparator<Integer> comparator = (o1, o2) -> o2 - o1;

		// now passing lambda expression
		List<Integer> numbers2 = getNumbers();
		Collections.sort(numbers2, comparator);

		System.out.println("sorted list in decending  order using lambda expression:" + numbers2);

		// 5
		List<Integer> numbers3 = getNumbers();
		Collections.sort(numbers3, Comparator.reverseOrder());
		System.out.println("sorted list in decending  order numbers3:" + numbers3);

		// Using Streams API:

		// 6

		List<Integer> sortedNumbers = getNumbers()

				.stream().sorted((a, b) -> a > b ? -1 : 1).collect(Collectors.toList());

		System.out.println("sortedNumbers:" + sortedNumbers);

		// 7
		List<Integer> sortedNumbers2 = getNumbers()

				.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

		System.out.println("sortedNumbers2:" + sortedNumbers2);

	}

	public static List<Employee> getEmployees() {

		return Stream
				.of(new Employee("102", "dev", "DEVELPMENT", Arrays.asList("6350233872", "6350233873"),
						Arrays.asList("devs383@gmil.com", "devrath92sharma@gmail.com"), 50000),
						new Employee("103", "rahul", "DEVELPMENT", Arrays.asList("7350233872", "7350233873"),
								Arrays.asList("fevs383@gmil.com", "eevrath92sharma@gmail.com"), 60000),
						new Employee("101", "aarav", "TESTING", Arrays.asList("8350233872", "8350233873"),
								Arrays.asList("fvs383@gmil.com", "fevrath92sharma@gmail.com"), 70000))
				.collect(Collectors.toList());

	}

	public static Map<String, Integer> getMap() {
		

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("eight", 8);
		map.put("four", 4);
		map.put("ten", 10);
		map.put("two", 2);
		map.put("one", 1);
		return map;

	}

	public static Map<Employee, Integer> getMapOfEmployeeAskey() {
		Employee e1 = new Employee("102", "dev", "DEVELPMENT", Arrays.asList("6350233872", "6350233873"),
				Arrays.asList("devs383@gmil.com", "devrath92sharma@gmail.com"), 50000);
		Employee e2 = new Employee("103", "rahul", "DEVELPMENT", Arrays.asList("7350233872", "7350233873"),
				Arrays.asList("fevs383@gmil.com", "eevrath92sharma@gmail.com"), 60000);

		Employee e3 = new Employee("101", "aarav", "TESTING", Arrays.asList("8350233872", "8350233873"),
				Arrays.asList("fvs383@gmil.com", "fevrath92sharma@gmail.com"), 70000);
		Map<Employee, Integer> map = new HashMap<Employee, Integer>();
		map.put(e1, 8);
		map.put(e2, 4);
		map.put(e3, 10);
		
		return map;

	}

	public static List<Integer> getNumbers() {

		return Stream.of(12, 7, 3, 9, 5, 6).collect(Collectors.toList());
	}

	public static List<String> getStrings() {

		return Stream.of("java", "hibernate", "tortoisegit", "springmvc", "springboot").collect(Collectors.toList());
	}
}
