package com.test;

public class MergeSort {

	public static void main(String[] args) {
		
		
		int[] a = {9,5,7,3,5,15,7,11};
		
		mergeSort(a,8);
		
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
		
		
		
		
	}

	private static void mergeSort(int[] a, int n) {
		
		//this method is responsible to divide the array in two parts
		if(n<2){
			return;
		}
		
		int mid = n/2;
		int[] left = new int[mid];
		
		int[] right = new int[n-mid];
		
		for (int i = 0; i < mid; i++) {
			left[i] = a[i];
	    }
	    for (int i = mid; i < n; i++) {
	        right[i - mid] = a[i];
	    }
		
		mergeSort(left,mid);
		mergeSort(right,n-mid);
		
		
		merge(a,left,right);
		
		
	}

	private static void merge(int[] a, int[] left, int[] right) {
		
		//this method merges the two sorted arrays
		int i=0;
		int j=0;
		int k=0;
		
		while(i<left.length && j<right.length){
			
			if(left[i] < right[j]){
				a[k++] = left[i++];
			}
			else{
				a[k++] = right[j++];
			}
		}
		
		while(i<left.length){
			a[k++] = left[i++];
		}
		
		while(j<right.length){
			a[k++] = right[j++];
		}
		
	}
}
