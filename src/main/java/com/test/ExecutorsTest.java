package com.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsTest {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService executor = Executors.newFixedThreadPool(10);
		CountDownLatch latch = new CountDownLatch(10);
		long start = System.nanoTime();
		for(int i=0;i<10;i++) {
			int k = i;
			executor.execute(() -> {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
                    System.out.println("Exception in thread");
				}
				System.out.println(k);
				latch.countDown();
			});
		}
		latch.await();
		executor.shutdown();
		long end = System.nanoTime();
		long execution = end - start;
	    System.out.println("Execution time: " + execution + " nanoseconds");
	}

}
