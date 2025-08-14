package com.test;

public class MultiThread implements Runnable{

	
	public static void main(String args[]){
		
		MultiThread multiThread = new MultiThread();
		Thread t1 = new Thread(multiThread);
		t1.start();
		Thread t2 = new Thread(new MultiThread());
		t2.start();
	}

	@Override
	public void run() {
		for(int i=0;i<10;i++){
			if(i%2 == 0){
				System.out.println("Even Number " + i);
			}else{
				System.out.println("Odd Number " +i);
			}
		}
		
	}
	
	
}
