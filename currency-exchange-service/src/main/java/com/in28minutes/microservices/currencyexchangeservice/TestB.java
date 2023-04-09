package com.in28minutes.microservices.currencyexchangeservice;

public class TestB {
	
	     public static String reverse(String s) {
	    	 
	    	 if(s.equals("")) {
	    		 
	    		 return s;
	    		 
	    	 }else {
	    		 
	    		 
	    		 return reverse(s.substring(1))+s.charAt(0);
	    	 }
	    	 
	     }
	    public static void main(String[] args) {
	    	 String str="";
	    	 String s="HELLO WORLD";
	    	 String temp=null;
	    	 String[] arr=s.split(" ");
	    	 for(int i=0;i<arr.length;i++) {
	    		 
	    		 temp=arr[i];
	    		 
	    		 str=str+" "+reverse(temp);
	    	}
	    	 
	    	 System.out.println(str);
	    	 
		}

}
