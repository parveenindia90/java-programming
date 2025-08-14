package com.test;

import java.util.concurrent.atomic.AtomicInteger;

class Count{

	AtomicInteger counter; 
	
	public Count(){
		counter = new AtomicInteger();
	}
	
	public void increment(){
		counter.getAndIncrement();
	}
	
}

public class ThreadImpl {
	
	public static void main(String args[]) throws InterruptedException{
		
		
		Count count = new Count();
		
		Runnable runnable1 = () -> {
				for(int i=0;i<1000;i++){
					count.increment();
				}
		};
		
		Runnable runnable2 = () -> {
				for(int i=0;i<1000;i++){
					count.increment();
				}
		};
		
		Thread t1 = new Thread(runnable1);
		Thread t2 = new Thread(runnable2);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(count.counter);
		
	}

}
