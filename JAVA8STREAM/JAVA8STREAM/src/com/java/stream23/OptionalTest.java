package com.java.stream23;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalTest {
	
	 public static void main(String[] args) throws Exception {
		
		   Optional<String> optional=Optional.empty();
			System.out.println(optional);//Optional.empty
		 
			//System.out.println(optional.get());//java.util.NoSuchElementException: No value present
			
			
           Optional<String> opt=Optional.of("");
           System.out.println("1:"+opt);//3:
           
           Optional<String> opt1=Optional.of("dev");
           System.out.println("2:"+opt1);
           
           //Optional<String> opt2=Optional.of(null);//java.lang.NullPointerException
           //System.out.println("3:"+opt2);
           
           Optional<String> opt3=Optional.ofNullable(null);
           System.out.println("4:"+opt3);
			
           Optional<String> opt4=Optional.ofNullable(null);
           //System.out.println("4:"+opt4.get());//java.util.NoSuchElementException: No value present
			
           List<Employee> employees=getEmployees();
           
           //Optional<String> optEmp=employees.stream().map(Employee::getEmpName).sorted((s1,s2)->s2.compareTo(s1)).findAny();
          // System.out.println("optEmp:"+optEmp);//Optional[dev]
           
           Optional<Employee> optEmp1=employees.stream().filter(emp->emp.getEmpName().equals("param")).findAny();
           System.out.println("optEmp1a:"+optEmp1);
           System.out.println("optEmp1b:"+optEmp1.orElse(new Employee()));
           System.out.println("optEmp1c:"+optEmp1.orElseGet(()->{ 
        	   
        	   Employee emp=new Employee("101","bheedu", "TESTING", Arrays.asList("8350233872", "8350233873"),
						Arrays.asList("fvs383@gmil.com", "fevrath92sharma@gmail.com"), 70000);
           
               return emp;
           }));
           
           //System.out.println("optEmp1a:"+optEmp1.orElseThrow(()->new Exception("bad request")));


          // System.out.println("optEmp1:"+optEmp1.get());//java.util.NoSuchElementException: No value present

           if(optEmp1.isPresent()) {
        	   
               System.out.println("optEmp1:"+optEmp1.get());

           }else {
               System.out.println("optEmp1:"+optEmp1.isPresent());//true

		   }
           
           optEmp1.ifPresent(emp->System.out.printf("emp:"+emp));
           

	}
	 
	 
	 public static List<Employee> getEmployees() {

			return Stream
					.of(new Employee("102", "dev", "DEVELPMENT", Arrays.asList("6350233872", "6350233873"),
							Arrays.asList("devs383@gmil.com", "devrath92sharma@gmail.com"), 50000),
							new Employee("103", "rahul", "DEVELPMENT", Arrays.asList("7350233872", "7350233873"),
									Arrays.asList("fevs383@gmil.com", "eevrath92sharma@gmail.com"), 60000),
							new Employee("101","aarav", "TESTING", Arrays.asList("8350233872", "8350233873"),
									Arrays.asList("fvs383@gmil.com", "fevrath92sharma@gmail.com"), 70000))
					.collect(Collectors.toList());

		}

	

}
