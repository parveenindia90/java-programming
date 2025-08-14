package com.test;

public class MatrixTraverseMaxWays {
	
	
	public static void main(String[] args) {
		int m=2;
		int n=3;
		System.out.println(numberOfPaths(m,n));
		
	}

	private static int numberOfPaths(int m, int n) {
		
		if(m ==1 || n == 1){
			return 1;
		}
		
		// If diagonal movements are allowed then
        // the last addition is required.
		return numberOfPaths(m - 1, n) + numberOfPaths(m, n - 1);
		 // + numberOfPaths(m-1, n-1);
		
	}

}
