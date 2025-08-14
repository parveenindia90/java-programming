package com.test;

import java.util.Stack;

public class StackImpl {

	 public static void main(String args[]){
		 
		 Stack<Integer> stack = new Stack<Integer>();
		 
		 stackPush(stack);
		 stackPop(stack);
		 stackPush(stack);
		 stackPeek(stack);		 
		 stackSeach(stack,5);
		 
	 }

	private static void stackSeach(Stack<Integer> stack, int i) {
	    int pos = stack.search(i);
		System.out.println(pos);
		
	}

	private static void stackPeek(Stack<Integer> stack) {
		
		System.out.println(stack.peek());
		
	}

	private static void stackPop(Stack<Integer> stack) {
		
		for(int i=0;i<5;i++){
			stack.pop();
		}
		
		
	}

	private static void stackPush(Stack<Integer> stack) {
		for(int i=0;i<5;i++){
			stack.push(i);
		}
	}
}
