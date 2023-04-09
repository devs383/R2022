package com.java.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindSecondHighestNumber {

	public static void main(String[] args) {

		List<Integer> number=new  ArrayList<>(Arrays.asList(1,3,5,2,7));
		
		number.stream().sorted((a,b)->(int)(b-a)).limit(2).skip(1).forEach(System.out::println);
		
		
		int n=5;
		int fact=n;
		while(n>1) {
			
			n--;
			fact=fact*n;
			
			
		}
		System.out.println(fact);
		
		String str="abcd";
		
		//convert string or array to list
		List<String> list=Arrays.asList(str.split(""));
		System.out.println(list);
		
		List<Integer> list1=new  ArrayList<>(Arrays.asList(1,3,5));
		List<Integer> list2=new  ArrayList<>(Arrays.asList(8,9,10,10));
		
		List<Integer> newList=IntStream.range(0, Math.min(list1.size(), list2.size())).boxed()
		.collect(Collectors.toList());
		System.out.println("newlist:"+newList);
		
		
		List<Integer> result = Stream.concat(list1.stream(), list2.stream())
                .distinct()
                .collect(Collectors.toList());
        
		
		System.out.println("result:"+result);

		
		
		
		
	}

}
