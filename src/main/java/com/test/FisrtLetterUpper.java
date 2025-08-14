package com.test;

public class FisrtLetterUpper {
	
	public static void main(String args[]){
		
		String str = "i love progamming";
		
		char[] ch = str.toCharArray();
		
		for(int i = 0;i<ch.length;i++){
			
			if(i ==0 || (i != 0 && ch[i-1] == ' ')){
				ch[i] = Character.toUpperCase(ch[i]);
			}
		}
		
		System.out.println(ch);
	}
}
