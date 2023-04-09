package com.java.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateNumbers {

	public static void main(String[] args) {
		List<Integer> number=Arrays.asList(1,4,3,1,6,4,1);
		
		//find duplicate number using frequency method
		number.stream().filter(e-> Collections.frequency(number, e)>1)
		.collect(Collectors.toSet())
		.forEach(System.out::println);
		
		//print number and its its occurence count in key value pair
		Map<Integer, Long> map=number.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	    System.out.println("number and its occurence count:"+map);

	    //find duplicate number along with count in key value pair
		Set<Map.Entry<Integer, Long>> duplicateNumWithCount=map.entrySet().stream().filter(entry->entry.getValue()>1).collect(Collectors.toSet());
	    System.out.println("only duplicateNumWithCount:"+duplicateNumWithCount);

	    //print  duplicate number
		Set<Integer> set=map.entrySet().stream().filter(entry->entry.getValue()>1).map(entry->entry.getKey()).collect(Collectors.toSet());
	    System.out.println("duplicate numbers:"+set);
	    
	    Set<Map.Entry<Integer,Long>> setm=number.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(entry->entry.getValue()>1).collect(Collectors.toSet());	    
	    System.out.println(setm);
	}
	
}
