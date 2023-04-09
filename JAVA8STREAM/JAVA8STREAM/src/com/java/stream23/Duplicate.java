package com.java.stream23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Duplicate {

	public static void main(String[] args) {
		//findTheOccurenceOfEachChar();
		
		//findSecondHighestNumber();
		
		findLongestString();
	}

	private static void findLongestString() {

		//approch1
		List<String> strs=Arrays.asList("abc","abcd","a","abcde","ab");
		strs.stream().sorted((s1,s2)->s2.length()-s1.length()).limit(1).forEach(System.out::println);
	
		//approch1
		List<String> strs1=Arrays.asList("abc","abcd","a","abcde","ab");
		String longestString=strs1.stream().reduce((s1,s2)->s1.length()>s2.length()?s1:s2).get();
	    System.err.println("longestString:"+longestString);
	}

	private static void findSecondHighestNumber() {
		List<Integer> numbers=Arrays.asList(2,9,5,3,6,1,1,1);
		
		//approach1
		numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).limit(1).forEach(System.out::println);
		Integer secondHighestNum=numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println("secondHighestNum:"+secondHighestNum);
        
         Integer secondLowestNum=numbers.stream().distinct().sorted().skip(1).findFirst().orElse(0);
         System.out.println("secondLowestNum:"+secondLowestNum);
         
         

	}

	private static void findTheOccurenceOfEachChar() {

		String str = "javatechie";

		List<String> list = Arrays.asList(str.split(""));

		// find frequency of each character in string
		Map<String, Long> map = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("map:" + map);

		// find all duplicate element from given string
		
		//approach1
		List<String> mapUsingFrequencyMethod = list.stream().filter(s -> Collections.frequency(list, s) > 1).distinct()
				.collect(Collectors.toList());
		System.out.println("mapUsingFrequencyMethod:" + mapUsingFrequencyMethod);

		//approach2
		List<Entry<String, Long>> duplicateElemetsWithOccurence=list.stream()
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet()
				.stream()
				.filter(entries->entries.getValue()>1)
				.collect(Collectors.toList());
		
		System.out.println("duplicateElemetsWithOccurence:" + duplicateElemetsWithOccurence);
		
		
		List<String> duplicateElemets=list.stream()
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet()
				.stream()
				.filter(entries->entries.getValue()>1)
				.map(entries->entries.getKey())
				.collect(Collectors.toList());
		
		System.out.println("duplicateElemets:" + duplicateElemets);

		//find first non duplicate element
		
		String firstNonRepeatElement=list.stream().collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
		.entrySet().stream()
		.filter(entry->entry.getValue()==1)
		.map(entry->entry.getKey())
		.findFirst().orElse("not found");
		
		System.out.println("firstNonRepeatElement:" + firstNonRepeatElement);
		
		

	}

}
