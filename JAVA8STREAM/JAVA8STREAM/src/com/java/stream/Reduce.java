package com.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class Reduce {

	public static void main(String[] args) {
		
		
		List<Integer> numbers=Arrays.asList(1,2,3,4,5);
		
		Optional<Integer> sum=numbers.stream().reduce((a,b)->a+b);
		//Optional<Integer> sum=Optional.ofNullable(numbers.stream().reduce(0,(a,b)->a+b));
        Optional<Integer> sum2=numbers.stream().map(n->n*2).reduce((a,b)->Integer.sum(a, b));
		System.out.println(sum.get());
		System.out.println(sum2.get());
		
		
		//find average of given numbers
		
		Optional<Integer> avg=numbers.stream().reduce(Integer::sum);
		System.out.println(avg.get());
		
		//avg
		
		double average=numbers.stream().mapToInt(e->e).average().getAsDouble();
		System.out.println("average:"+average);
		
		
		double squreAverage=numbers.stream().mapToInt(e->e*e).average().getAsDouble();
        System.out.println(squreAverage);
	}
}
