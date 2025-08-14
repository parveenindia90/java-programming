package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

@FunctionalInterface
interface Test{
	
	void show(int i, float k);
	default public void show1(int i,String j){
	   System.out.println("afas");	
	}
	
}

public class LambdaDemo {
	
	public static void main(String args[]){
		
		Test obj = (i,k) -> {
			System.out.println("hEllo");
		};
		
		obj.show(4,(float)7.8);
		
		List<Integer> values =  Arrays.asList(3,2,3,4,5,6);
		
		Predicate<Integer> p1 = t -> t>3;
		
		Consumer<Integer> c = t -> {		 
				if(p1.test(t)){
					System.out.println(t);
				}
		};
		
		values.forEach(c);  //consumer interface
		//values.forEach(System.out :: println); // method reference
	}

}
