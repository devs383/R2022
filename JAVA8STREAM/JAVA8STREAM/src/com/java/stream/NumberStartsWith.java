package com.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberStartsWith {

	public static void main(String[] args) {

		List<Integer> numIntegers=Arrays.asList(223,123,234,321,267);
		
		List<Integer> list=numIntegers.stream().map(e->String.valueOf(e)).filter(e->e.startsWith("2"))
				.map(e->Integer.valueOf(e))
				.limit(1)
				.collect(Collectors.toList());
		
		System.out.println(list);
		
		
		
	}

}
