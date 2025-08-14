package com.test;

import java.util.ArrayList;
import java.util.List;

public class TrainangleProblem {

	
	public static void main(String args[]){
		
		int n = 5;
		List<Integer> list = new ArrayList<>();
		for(int i=1;i<=n;i++){
			list.add(i);
			for(int k=0;k<list.size();k++){
				System.out.print(list.get(k));
			}
			System.out.print(" ");			
			for(int j=n;j>=i;j--){
				System.out.print(j);
			}
			
			System.out.println();
			
		}
		
		
		
	}
}
