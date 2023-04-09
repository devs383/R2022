package com.java.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ComposeMapOutOfTwoListAsKeyValue {

	public static void main(String[] args) {

		List<Integer> list1=new ArrayList<Integer>(Arrays.asList(1,2));
		List<String> list2=new ArrayList<String>(Arrays.asList("A","B","C","D"));
		
		//map list 1 data with list 2 data as key value pair
		Map<Integer, String> map=IntStream.range(0, Math.min(list1.size(), list2.size())).boxed()
		.collect(Collectors.toMap(list1::get, list2::get));
		
		System.out.println(map);
		
		//2nd way
		Map<Integer, String> map2=IntStream.range(0,list1.size()).boxed()
				.collect(Collectors.toMap(list1::get, list2::get));
				
				System.out.println(map2);
				
				
		//using auxiliary(helper) list		
				List<Integer> list0 = Arrays.asList(0, 1);
				   Map<Integer, String> map3 = list0.stream()
			            .collect(Collectors.toMap(list1::get, list2::get));	
					System.out.println(map3);

	    }
	
	   
	}

