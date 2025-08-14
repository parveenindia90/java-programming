package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class TestingClass{

	
	// Concatenates to String 
    public static void concat1(String s1) 
    { 
        s1 = s1 + "forgeeks"; 
    } 
  
    // Concatenates to StringBuilder 
    public static void concat2(StringBuilder s2) 
    { 
        s2.append("forgeeks"); 
    } 
  
    // Concatenates to StringBuffer 
    public static void concat3(StringBuffer s3) 
    { 
        s3.append("forgeeks"); 
    } 
  
    public static void main(String[] args) 
    { 
        /*String s1 = "Geeks"; 
        concat1(s1);  // s1 is not changed 
        System.out.println("String: " + s1); 
  
        StringBuilder s2 = new StringBuilder("Geeks"); 
        concat2(s2); // s2 is changed 
        System.out.println("StringBuilder: " + s2); 
  
        StringBuffer s3 = new StringBuffer("Geeks"); 
        concat3(s3); // s3 is changed 
        System.out.println("StringBuffer: " + s3);*/
    	
    	char c= 'd';
    	
    	System.out.println(c+2);
    } 
    
	public static void main1(String args[]){
		
		Predicate<Employee>p1=e-> e.getEmpSalary()<10000 && e.getGender().equals("F");
		
		Function<Employee, Integer> f1 =(s1) -> s1.getEmpId();
		Function<Integer, Integer> f2 =(s1) -> s1*s1;
		List<Employee> empList = new ArrayList();
		empList.add(new Employee(103,"Parveen",16000.0,"M","India","INR"));
		empList.add(new Employee(102,"Jitendra",13000.0,"F","America","USD"));
		empList.add(new Employee(101,"Rohit",9000.0,"M","France","EUR"));
		empList.add(new Employee(104,"Tinku",7000.0,"F","India","INR"));
		
		
		Consumer<Integer> consumer = (var1) -> System.out.println(var1);
		
		//consumer.accept(1);
		
		for(Employee emp : empList){
			if(p1.test(emp)){
				//System.out.println(f1.andThen(f2).apply(emp));
			}
		}
		
		List<Integer> values =Arrays.asList(4,5,6,7,18);
		
		
		System.out.println(values.stream().filter(i -> i>10).mapToInt(j -> j+j).sum());
		
	}

}
