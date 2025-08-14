package com.test;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianRunningIntegers {
	
	PriorityQueue<Integer> maxHeap = null;
	PriorityQueue<Integer> minHeap = null;
	
	public MedianRunningIntegers(){
		maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		minHeap = new PriorityQueue<>();
	}
	private void insert(int i) {
		if(maxHeap.isEmpty() || i <= maxHeap.peek()){
			maxHeap.add(i);
		}else{
			minHeap.add(i);
		}
		
		if(maxHeap.size() > minHeap.size()+1){
			minHeap.add(maxHeap.poll());
		}else if(maxHeap.size() < minHeap.size()){
			maxHeap.add(minHeap.poll());
		}
		
		
	}
	
	private int findMedian() {
		if(maxHeap.size() == minHeap.size()){
			return (maxHeap.peek() + minHeap.peek())/2;
		}else{
			return maxHeap.peek();
		}
	}
	
    public static void main(String[] args){
    	MedianRunningIntegers runningIntegers = new MedianRunningIntegers();
    	runningIntegers.insert(3);
    	runningIntegers.insert(1);
    	runningIntegers.insert(5);
    	runningIntegers.insert(7);
    	runningIntegers.insert(6);
    	runningIntegers.insert(8);
    	System.out.println(runningIntegers.findMedian());
    }

}
