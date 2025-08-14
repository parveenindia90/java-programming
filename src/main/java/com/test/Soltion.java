package com.test;

public class Soltion {

	public static void main(String[] args) {
		
		int[] arr = new int[] {1,2,3,5,7,8};
		int k=1;
		
		System.out.println(soltion(arr,k));
		

	}

	private static boolean soltion(int[] arr,int k) {
		int start =0;
		int end = arr.length-1;
		
		while(start<=end) {
			
			int mid = (start+end)/2;
			if(k==arr[mid]) {
				return true;
			}
			
			if(arr[mid] > k) {
				end = mid-1;
			}else {
				start = start+1;
			}
		}
		
		return false;
	}

}
