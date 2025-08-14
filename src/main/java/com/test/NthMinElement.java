package com.test;

import java.util.Collections;
import java.util.PriorityQueue;

public class NthMinElement {

	public static void main(String args[]){
		
		int[] arr = {9,4,5,7,2,9,3};
		
		System.out.println(nthMaxElement(arr,3));
	}

	private static int nthMaxElement(int[] arr, int n) {
		//priority queue is used to solve these problems. It will be a max heap 
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0;i<n;i++){
			queue.add(arr[i]);
		}
		
		for(int i=n;i<arr.length;i++){
			if(arr[i] < queue.peek()){
				queue.poll();
				queue.add(arr[i]);
			}
		}
		return queue.peek();
	}
}
