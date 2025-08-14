package com.test;

import java.util.Stack;

public class StackMinElement {

public static void main(String args[]){
		
		StackImp s = new StackImp();
		
		s.push(3);
        s.push(5); 
        s.getMin(); 
        s.push(2); 
        s.push(1); 
        s.getMin(); 
        s.pop(); 
        s.getMin(); 
        s.pop(); 
        s.peek(); 
		
	}
}

class StackImp{
	
	Stack<Integer> stack = new Stack<>();
	Integer minValue;
	public void push(int i) {
		if(stack.isEmpty()){
			minValue = i;
			stack.push(i);
		}else if(i < minValue){
			minValue = i;
			stack.push(2*i-minValue);
		}else{
			stack.push(i);
		}
		
		System.out.println("Value inserted is : "+ i);
	}
	public void pop() {
	
		if(stack.isEmpty()){
			System.out.println("Stack is empty");
			return;
		}
		
		int i = stack.pop();
		if(i < minValue){
			minValue = 2*minValue-i;
			System.out.println(minValue);
		}else{
			System.out.println(i);
		}
		
	}
	public void peek() {
		
		if(stack.isEmpty()){
			System.out.println("Stack is empty");
			return;
		}
		
		int i = stack.peek();
		if(i < minValue){
			System.out.println(minValue);
		}else{
			System.out.println(i);
		}
		
	}
	public void getMin() {
		if(stack.isEmpty()){
			System.out.println("Stack is empty");
		}else{
			System.out.println("Min Value is "+minValue);
		}
		
	}
	
	
	
}