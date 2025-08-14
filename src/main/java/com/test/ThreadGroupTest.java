package com.test;

public class ThreadGroupTest {

	public static void main(String args[]){
		
		ThreadGroup group = new ThreadGroup("First Thread Group");
		ThreadGroup group2 = new ThreadGroup(group,"Second Thread Group");	
		
		MyThread thread1 = new MyThread(group,"Child Thread");
		thread1.start();
		
		MyThread thread2 = new MyThread(group,"Child Thread 2");
		thread2.start();
		
		System.out.println(group.activeGroupCount());
		
		//to diplay all active threads in System group and its child group
		
		ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
		
		Thread[] t = new Thread[system.activeCount()];
		
		system.enumerate(t);
		
		for(Thread t1 : t){
			System.out.println(t1.getName());
		}
		
	}
}

class MyThread extends Thread
{
	MyThread(ThreadGroup g , String name )
	{
	  super(g,name);
	}
	
	@Override
	public void run(){
		System.out.println("Child Thred");
	}
}