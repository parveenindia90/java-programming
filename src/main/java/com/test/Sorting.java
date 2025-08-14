package com.test;import java.util.stream.IntStream;

public class Sorting {

	  public static void main(String args[]){
			int[] arr = {64,25,12,22,11};
		    int n = selectionSort(arr);
			
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i]+" "); 
	        
	        IntStream.of(arr).sorted();
	        
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i]+" "); 
	  }

		private static int selectionSort(int[] arr) {
			int n = arr.length;
			
			for(int i=0;i<n-1;i++) {
				int min = i;
				
				for(int j=i+1;j<n;j++) {
					if(arr[j] < arr[min]) {
						min = j;
					}
				}
				
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
				
			}
			
			return n;
		}
		
		private static int insertionSort(int[] arr) {
			int n = arr.length;
			for(int i=1;i<n;i++){
				
				int curr  = arr[i];
				int j = i-1;
				
				while(j >= 0 && arr[j]>curr){
					arr[j+1] = arr[j]; 
					j--;
				}
				arr[j+1] = curr;
			}
			return n;
		}
}

