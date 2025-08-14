package com.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceDemo{
	
	public static void main(String args[]) throws InterruptedException, ExecutionException{
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		//Runnable task =  () -> System.out.println("Thread Executing");
		
		Callable<String> callTask =  () -> {
		    
			return "Thread Executing";
			
		};
		
		Future<String> future  = executorService.submit(callTask);
		
		System.out.println(future.get());
	}
	
}
