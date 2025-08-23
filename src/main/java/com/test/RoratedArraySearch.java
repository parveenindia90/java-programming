package com.test;

public class RoratedArraySearch {

	public static void main(String[] args) {
		int[] arr = {8,11,13,15,1,4,6};
		int k = 1;
		int index = solution(arr,k);
		System.out.println(index);
	}

	private static int solution(int[] arr, int k) {
		int start = 0;
		int end = arr.length-1;
		
		while(start <= end){
			
			int mid = (start+end)/2;
			if(k == arr[mid]){
				return mid;
			}
			
			//if left array is sorted
			if(arr[start] < arr[mid]){
				if(k < arr[mid] && k >= arr[start]){
					end = mid - 1;
				}else{
					start= mid + 1;
				}
			}
			
			//if right array is sorted
			else{
				if(k > arr[mid] && k <= arr[end]){
					start = mid + 1;
				}else{
					end = mid - 1;
				}
			}
		}
		
		return -1;
	}
	
}