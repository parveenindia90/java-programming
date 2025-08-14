package com.test;

public class SingletonDemo implements Cloneable{

	private static SingletonDemo instance;
	
	private SingletonDemo() throws Exception{
		if(instance != null){
			throw new Exception();
		}
	}
	
	public static SingletonDemo getInstance() throws Exception{
		if(instance == null){
			synchronized (SingletonDemo.class){
				if(instance == null){
				   instance = new SingletonDemo();
				}
			}
		}
		 
		return instance;
	}
	
	public SingletonDemo clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
	}
	
	
	
	
}
