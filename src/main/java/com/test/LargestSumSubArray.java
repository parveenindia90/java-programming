package com.test;

public class LargestSumSubArray {
	
	public static void main(String[] args) {
		int[] arr = {2,-3,4,-1,-2,1,5,-3};
		
		solution(arr);
	}

	private static void solution(int[] arr) {
		/*to find largest sum , if we find sum < 0 at any point then again start 
		to calculate the sum and  compare it with the previous sum ,
		if it is max then replace previous sum with curr summ*/
		
		int maxSum = arr[0];
		int currSum = 0;
		int start =0;
		int end =0;
		int s = 0;
		for(int i=0;i<arr.length;i++){
			currSum += arr[i];
			
			if(currSum > maxSum){
				maxSum = currSum;
				start = s;
				end = i;
			}
			
			if(currSum < 0){
				currSum = 0;
				s = i+1;
			}
		}
		
		System.out.println(maxSum);
		System.out.println(start +" and "+ end);
		
		
	}

}
