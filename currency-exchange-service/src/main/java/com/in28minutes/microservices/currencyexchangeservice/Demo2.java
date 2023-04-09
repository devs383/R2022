package com.in28minutes.microservices.currencyexchangeservice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo2 {

	public static void main(String[] args) {
		
		Stream<Integer> s=Stream.of(2,4,3,1,2);
        Set<Integer> set=new HashSet();
        
       s.filter(i->!set.add(i)).forEach(System.out::println);
        
        //System.out.println(set);
        
	}

}
