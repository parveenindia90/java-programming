package com.test;

public class EvenOddTester{
	
	public static void main(String args[]){
		
		PrintEvenOdd printEvenOdd = new PrintEvenOdd();
		Thread oddThred = new Thread(new EvenOddTask(10, printEvenOdd, true),"Odd");
		Thread evenThred = new Thread(new EvenOddTask(10, printEvenOdd, false),"Even");
		
		oddThred.start();
		evenThred.start();
	}
}

class EvenOddTask implements Runnable {

	private int max;
	private PrintEvenOdd print;
	private boolean isOdd;
	
	public EvenOddTask(int max, PrintEvenOdd print, boolean isOdd) {
		this.max = max;
		this.print = print;
		this.isOdd = isOdd;
	}
	
	public void run(){
		
		int num = isOdd ? 1:2;
		
		while(num <= max){
			if(isOdd){
				print.printOddNumber(num);
			}else{
				print.printEvenNumber(num);
			}
			num += 2;
		}
	}
	
	
}

class PrintEvenOdd
{
	private boolean isOdd = true;
	synchronized void printEvenNumber(int number){
		 while(isOdd){
			 try{
				 wait();
			 }catch(Exception e){
				 System.out.println("Exception Occured");
			 }
		 }
		 System.out.println(Thread.currentThread().getName() +" : "+number);
		 isOdd = true;
		 notifyAll();
	}
	
	synchronized void printOddNumber(int number){
		 while(!isOdd){
			 try{
				 wait();
			 }catch(Exception e){
				 System.out.println("Exception Occured");
			 }
		 }
		 System.out.println(Thread.currentThread().getName() +" : "+number);
		 isOdd = false;
		 notifyAll();
	}
	
}
