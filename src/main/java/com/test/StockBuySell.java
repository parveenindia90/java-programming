package com.test;

public class StockBuySell {

	public static void main(String args[]){
		
		int[] arr = {2,3,1,8,9,5,6};
		int n = arr.length;
		
		int min = arr[0];
		int maxProfit = 0;
		
		for(int i=0;i<n;i++){
			min = Math.min(min, arr[i]);
			int profit = arr[i] - min;
			maxProfit = Math.max(maxProfit, profit);
		}
		
		
		System.out.println(maxProfit);
	}
}
