package com.test;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
	
	public static void main (String[] args) {
		
		String firstString = "geeksforgeeks";
		String secondString = "forgeeks";
		boolean anagram = checkForAnagram(firstString,secondString);
		
		if(anagram){
			System.out.println("String are anagram");
		}else{
			System.out.println("String are not anagram");
		}
	
	}
	
	public static boolean checkForAnagram(String firstString,String secondString){
		    
		    char[] str1 = firstString.toLowerCase().toCharArray();
		    char[] str2 = secondString.toLowerCase().toCharArray();
		    Arrays.sort(str1);
		    Arrays.sort(str2);
		    
		    if(str1.length != str2.length)
		    	return false;
		    if(str1.length == str2.length){
		        for(int i=0;i<str1.length;i++){
		        	if(str1[i] != str2[i])
		        		return false;
		        }
		    }
		    
			return true;
	}
}