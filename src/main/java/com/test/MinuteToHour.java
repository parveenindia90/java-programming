package com.test;

public class MinuteToHour {

	public static void main(String[] args) {
		
/*		1
		2
		Fizz
		4
		Buzz
		Fizz
		7
		8
		Fizz
		Buzz
		11
		Fizz
		13
		14
		FizzBuzz
		16
*/
		
		for(int i=1;i<=100;i++){
			String s ="";
			if(i%3 == 0){
				s = s.concat("Fizz");
			}
			if(i%5 == 0){
				s = s.concat("Buzz");
			}
			if(i%7 == 0){
				s = s.concat("Brown");
			}
			
			if("".equals(s)){
				System.out.println(i);
			}else{
				System.out.println(s);
			}
		}
		

	}

}
