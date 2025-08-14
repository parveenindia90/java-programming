package com.test;

interface I{
	default void show(){
		 System.out.println("I");
	 }
	
	static void print(){
		System.out.println("Static I");
	}
	
	//a default method can not override a method of object class
	/*default boolean equals(Object e){
		System.out.println("");
	}*/
}

interface J{
	default void show(){
		 System.out.println("J");
	 }	
}

class In{
	 public void show(){
		 System.out.println("A");
	 }
}
public class ThirdRuleJava extends In implements I,J{

	//ThirdRuleJava gives higher priority to class method than interface
	public static void main(String args[]){
		ThirdRuleJava  interfaceTesting = new ThirdRuleJava();
		interfaceTesting.show();
		
		//to access static method of Interface
		I.print();
	}
}
