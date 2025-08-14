package com.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonPattern {

	public static void main(String args[]) throws Exception{
		SingletonClass singletonClass = SingletonClass.getInstance();
		SingletonClass singletonClass1 = null;
		
		/*Constructor[] con = SingletonClass.class.getDeclaredConstructors();
		
		for(Constructor c : con){
			c.setAccessible(true);
			singletonClass1 = (SingletonClass) c.newInstance();
		}
		*/
		System.out.println(singletonClass.hashCode());
		System.out.println(singletonClass1.hashCode());
	}
}

class SingletonClass{
	
	private static SingletonClass singletonClass;
	
	private SingletonClass() throws Exception{
		if(singletonClass != null){
			throw new Exception();
		}
	}
	
	public static SingletonClass getInstance() throws Exception{
		if(singletonClass == null){
			synchronized(SingletonClass.class){
				if(singletonClass == null){
					singletonClass = new SingletonClass();
				}
			}
		}
		return singletonClass;
	}
	
}