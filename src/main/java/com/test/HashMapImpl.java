package com.test;

import java.util.HashMap;
import java.util.Map; 

class Employee1 { 
    String empName; 
    Employee1(String empName) 
    { 
        this.empName = empName; 
    } 
  
    @Override
    public int hashCode() 
    { 
        return 1; 
    } 
  
    @Override
    public boolean equals(Object obj) 
    { 
        return empName.equals(((Employee1)obj).empName); 
    } 
} 

public class HashMapImpl { 
    public static void main(String[] args) 
    { 
        Map<Employee1,Integer> map = new HashMap(); 
        map.put(new Employee1("vishal"), 20); 
        map.put(new Employee1("sachin"), 30); 
        map.put(new Employee1("vaibhav"), 40); 
  
        System.out.println("Value for key vishal: " + map.get("vishal")); 
        System.out.println("Value for key sachin: " + map.get(new Employee1("sachin"))); 
        System.out.println("Value for key vaibhav: " + map.get(new Employee1("vaibhav"))); 
    } 
} 