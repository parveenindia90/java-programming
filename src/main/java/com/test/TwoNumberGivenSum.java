package com.test;

import java.util.Arrays;

public class TwoNumberGivenSum {

	public static void main(String args[]) {
		
		int[] arr1 = {1,2,3,4,5,6,7,8,9,10};
		Arrays.sort(arr1);
		int number = 15;
		int left = 0;
		int right = arr1.length-1;
		
		while(left < right){
			if(arr1[left] + arr1[right] == number){
				System.out.println(arr1[left] + " and " + arr1[right]);
				left++;
				right--;
			}else if(arr1[left] + arr1[right] < number){
				left++;
			}else{
				right--;
			}
		}
	}
	//Subarray with given sum
}
