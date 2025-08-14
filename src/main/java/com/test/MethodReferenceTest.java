package com.test;

interface Parser{
	
	String parse(String str);
		
}

class StringParser{
	
	public String convert(String str){
		if(str.length() > 3){
			str = str.toUpperCase();
		}else{
			str = str.toLowerCase();
		}
		return str;
	}
}

class MyPrinter{
	
	public void print(String str,Parser p){
		str = p.parse(str);
		System.out.println(str);
	}
}

public class MethodReferenceTest {

	public static void main(String args[]){
		StringParser stringParser = new StringParser();
		String str = "Pa";
		MyPrinter myPrinter = new MyPrinter();
		myPrinter.print(str, stringParser::convert);
	}
}
