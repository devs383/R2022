package com.java.stream23;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OtherInterviewQuestions {

	public static void main(String[] args) {

		// findElementStartWithone();

		// skipLimitExample();

		// mapAndFlatMapExample();

		highestPaidEmpInEachDepartmnet();
		
		//how to find second highest employee in each department?

	}

	private static void highestPaidEmpInEachDepartmnet() {

		List<Employee> employees = getEmployees();

		Map<String, Optional<Employee>> map = employees.stream().collect(Collectors.groupingBy(

				Employee::getDept, Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))
		// Collectors.collectingAndThen(Collectors.averagingDouble(Employee::getSalary),
		// Optional::get)

		));

		map.forEach((e1, e2) -> System.out.println(e1 + "::0::" + e2));

		// -------------------------------------------------------------

		Map<String, Object> map2 = employees.stream().collect(Collectors.groupingBy(

				Employee::getDept, Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)));

		map2.forEach((e1, e2) -> System.out.println(e1 + "::2::" + e2));

		// -------------------------averaging salary of each department employees

		Map<String, Double> map1 = employees.stream().collect(Collectors.groupingBy(

				Employee::getDept, Collectors.averagingDouble(Employee::getSalary)));

		map1.forEach((e1, e2) -> System.out.println(e1 + "::1::" + e2));

		// -----------------------------summing salary of each department employees

		Map<String, Double> map3 = employees.stream().collect(Collectors.groupingBy(

				Employee::getDept, Collectors.summingDouble(Employee::getSalary)));

		map3.forEach((e1, e2) -> System.out.println(e1 + "::3::" + e2));
		
		// -----------------------------summing salary of each department employees

				Map<String, Object> map4 = employees.stream().collect(Collectors.groupingBy(

						Employee::getDept, 
						Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(Employee::getSalary)),Optional::get)
						
						));

				map4.forEach((e1, e2) -> System.out.println(e1 + "::4::" + e2));
				
				
				// -----------------------------summing salary of each department employees

				Map<String, Object> map5 = employees.stream().collect(Collectors.groupingBy(

						Employee::getDept, 
						Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(Employee::getEmpName)),Optional::get)
						
						));

				map5.forEach((e1, e2) -> System.out.println(e1 + "::5::" + e2));

	}

	private static void mapAndFlatMapExample() {

		List<Employee> list = getEmployees();

		List<String> depts = list.stream().map(emp -> emp.getDept()).collect(Collectors.toList());
		System.out.println("depts:" + depts);

		List<List<String>> phones = list.stream().map(emp -> emp.getPhones()).collect(Collectors.toList());
		System.out.println("phones:" + phones);
		List<String> mails = list.stream().flatMap(emp -> emp.getMails().stream()).collect(Collectors.toList());
		System.out.println("mails:" + mails);

	}

	private static void skipLimitExample() {

		IntStream.range(1, 10).skip(1).limit(3).forEach(System.out::println);
	}

	private static void findElementStartWithone() {

		List<Integer> elements = Arrays.asList(1, 2, 3, 14, 5, 18);

		elements.stream().map(e -> String.valueOf(e)).filter(e -> e.startsWith("1")).collect(Collectors.toList())
				.forEach(System.out::println);

		elements.stream().map(String::valueOf).filter(e -> e.startsWith("1")).collect(Collectors.toList())
				.forEach(System.out::println);

		// String.join
		List<String> elements1 = Arrays.asList("1", "2", "3", "14", "5", "18");

		String str = String.join("-", elements1);
		System.out.println(str);

		String joinedStrElement = elements1.stream().map(e -> e.toUpperCase()).collect(Collectors.joining("_"));

		System.out.println(joinedStrElement);

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
