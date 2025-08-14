package com.test;

public class StringReverseByWords {
	
	public static void main(String args[]){
		
		String str = "i.like.this.program.very.much";
		
			    String[] strarr=str.split("\\.");
			    String revString = "";
			    int j=0;
			    for(j=strarr.length-1;j>=0;j--)
	            {
			    	revString = revString  +strarr[j]+".";
	            }
	            System.out.println(revString.substring(0,revString.length()-1));
	}


}
