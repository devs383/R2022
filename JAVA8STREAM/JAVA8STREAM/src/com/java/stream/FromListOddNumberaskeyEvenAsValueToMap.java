package com.java.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FromListOddNumberaskeyEvenAsValueToMap {

	public static void main(String[] args) {

		List<Integer> list=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7));
		
		List<Integer> oddList=list.stream().filter(n->n%2!=0).collect(Collectors.toList());
		List<Integer> evenList=list.stream().filter(n->n%2==0).collect(Collectors.toList());

		Map<Integer, Integer> map=IntStream.range(0, Math.min(oddList.size(),evenList.size())).boxed()
				.collect(Collectors.toMap(oddList::get, evenList::get));
		System.out.println(map);
	}

}
