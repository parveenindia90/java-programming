package com.test;

public class SplitEvenWords {

	public static void main(String args[]){
		
		
		String str = "Hello I am Mike Saunders";
		String newString = "";
		String[] strArr = str.split(" ");
		
		for(String word : strArr){
			if(word.length() >= 4  && word.length() % 2 == 0){
				String st = word.substring(0,word.length()/2) + " " + word.substring(word.length()/2,word.length());
				newString = newString + " " + st;
			}else{
				newString = newString + " " + word;
			}
		}
		
		System.out.println(newString.trim());
	}
}
