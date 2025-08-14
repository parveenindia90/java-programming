package com.test;

import java.util.LinkedList;
import java.util.Queue;

public class QueueImpl {

	public static void main(String args[]){
		
		Queue<String> queue = new LinkedList();
		queue.add("Ram");
		queue.add("Parveen");
		queue.add("Rahul");
		
		System.out.println(queue.poll());
		System.out.println(queue.element());
		
	}
}
