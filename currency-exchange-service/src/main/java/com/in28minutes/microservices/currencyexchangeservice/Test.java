package com.in28minutes.microservices.currencyexchangeservice;

import java.util.HashMap;
import java.util.Map;

public class Test {
	
	public static boolean test(String s1,String s2) {
		boolean flag=false;
		if(s1.equals(s2)) {
			
			return true;
		}else {
			
			flag=test(s1.substring(1)+s1.charAt(0),s2);
			
		}
		 
	    
		
		return flag;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String str=“sncrblr”;
		//{s=1, n=1, c=1, r=2, b=1, l=1}
		
		String str="sncrblr";
		
		Map<Character,Integer> map=new HashMap<Character, Integer>();
		
		for(int i=0;i<str.length();i++) {
			
			if(map.get(str.charAt(i))!=null) {
				
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
				
				
			}else {
				
				map.put(str.charAt(i), 1);
				
				
			}
			
			
			
		}
         
		System.out.println(map);
		
		//WATER
		
		//ATERW
		//TERWA
		//TERAW
		
		
		System.out.println(test("WATER","ATERWA"));

	}

}
