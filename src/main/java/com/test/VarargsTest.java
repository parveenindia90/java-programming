package com.test;

public class VarargsTest
{
	
	 public static void main(String[] args){
		 VarargsTest test = new VarargsTest();
		 
		 test.displayNumbers(6);
		 test.displayNumbers(6,5,6);
		 test.displayNumbers(6,89,9);
	 }

	 public void displayNumbers(int ... i){
		 System.out.println("First");
		 for(int j : i){
			 System.out.println(j);
		 }
	 }
	 
	 public void displayNumbers(int i){
		     System.out.println("Second");
			 System.out.println(i);
	 }
}
