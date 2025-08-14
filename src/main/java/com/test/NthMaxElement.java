package com.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class NthMaxElement {

	public static void main(String args[]){
		
		int[] arr = {5,4,6,8,1,2,7,1};
		
	//	System.out.println(nthMaxElement(arr,3));
		
		System.out.println(IntStream.of(arr).boxed().sorted(Collections.reverseOrder()).distinct().limit(3).skip(2).findFirst().get());
	}

	private static int nthMaxElement(int[] arr, int n) {
		//priority queue is used to solve these problems. It will be a min heap
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for(int i=0;i<n;i++){
			queue.add(arr[i]);
		}
		
		for(int i=n;i<arr.length;i++){
			if(arr[i] > queue.peek()){
				queue.poll();
				queue.add(arr[i]);
			}
		}
		
		
		return queue.peek();
		
		
	}
}
