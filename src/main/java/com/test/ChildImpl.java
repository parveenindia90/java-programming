package com.test;

abstract class PranetImpl {

	public int i;
	
	public PranetImpl(int i){
		System.out.println("In constructor");
		this.i = i;
	}
	
	public abstract void show();
}

public class ChildImpl extends PranetImpl
{

	public ChildImpl(int i) {
		super(i);
	}

	public static void main(String args[]){
		
		PranetImpl abs = new ChildImpl(9);
		abs.show();
	}
	
	@Override
	public void show() {
		System.out.println("In child show");
	}
	
}
