package com.java.stream23;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrallelStream {
	
	public static void main(String[] args) {
		
		long start=System.currentTimeMillis();
		
		IntStream.range(1, 11).forEach(i->System.out.println(Thread.currentThread().getName()+":"+i));
		
		long end=System.currentTimeMillis();
		
		System.out.println("time taken:"+(end-start));
		
		
		start=System.currentTimeMillis();
		IntStream.range(1,11).parallel().forEach(i->System.out.println(Thread.currentThread().getName()+":"+i));
		end=System.currentTimeMillis();
		
		System.out.println("time taken parallel:"+(end-start));

		
		
	}

}
