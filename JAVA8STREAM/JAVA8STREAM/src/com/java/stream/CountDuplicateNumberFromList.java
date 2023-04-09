package com.java.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CountDuplicateNumberFromList {

	public static void main(String[] args) {
		
		List<Integer> list=new ArrayList<Integer>(Arrays.asList(1,2,2,2,4,4,5,5));
		
		List<Integer> count=list.stream().filter(e->Collections.frequency(list,e)>1).collect(Collectors.toList());

		System.out.println(count);
		
		Long count2=list.stream().filter(e->Collections.frequency(list,e)>1).collect(Collectors.toSet()).stream().count();
		System.out.println(count2);

	}
}
