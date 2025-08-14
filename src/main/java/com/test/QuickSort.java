package com.test;

public class QuickSort {
	
	public static void main(String[] args) {
		int[] arr = new int[]{2,8,6,5,9,3};
		quickSort(arr,0,5);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}

	private static void quickSort(int[] arr, int i, int j) {
		if(i<j){
			
			int partition = partition(arr,i,j);
			quickSort(arr,i,partition-1);
			quickSort(arr,partition+1,j);
			
			
		}
		
	}

	private static int partition(int[] arr, int l, int h) {

		//take first element as pivot
		int pivot = arr[l];
		int i=l;
		int j=h;
		while(i<j){
			
			//keep on increasing i till pivot is greater then a[i]
			while(arr[i] <= pivot){
				i++;
			}
			//keep on decreasing j till pivot is less then a[j]
			while(arr[j] > pivot){
				j--;
			}
			
			///swap i  and j  if i <j
			if(i<j){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			
		}
		
		//swap j with pivot position
		int temp = arr[j];
		arr[j] = arr[l];
		arr[l] = temp;
		
		return j;
	}

}
