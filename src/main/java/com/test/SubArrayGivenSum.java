package com.test;

import java.util.HashMap;

public class SubArrayGivenSum {
	
	public static void main(String[] args) {
		int[] arr = {10,15,-5,15,-10,5};
		int sum = 5;  //to find
		
		solution(arr,sum);
	}

	private static void solution(int[] arr, int sum) {
		
		int currSum = 0;
		int n = arr.length;
		int start =0 ;
		int end = -1;
		HashMap<Integer,Integer> sumMap = new HashMap<>();
		for(int i=0;i<n;i++){
			currSum += arr[i];
			if(currSum - sum == 0){
				start = 0;
				end = i;
				break;
			}
			
			if(sumMap.containsKey(currSum-sum)){
				start = sumMap.get(currSum - sum) +1;
				end = i;
				break;
			}
			
			sumMap.put(currSum, i);
			
		}
		
		if(end == -1){
			System.out.println("Not found");
		}else{
			System.out.println(start + " to " + end);
		}
		
	}

}
