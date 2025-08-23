package com.test;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		int[] arr = {20,12,8,14,5,7,16}; //output -> -1,14,14,16,7,16,-1
		
		int[] res = solution(arr);

        for (int re : res) {
            System.out.println(re);
        }
	}

	private static int[] solution(int[] arr) {
		
		Stack<Integer> stack = new Stack<>();
		int[] res = new int[arr.length];
		for (int i=arr.length-1; i>=0; i--){
			while(!stack.isEmpty() && stack.peek() < arr[i]){
				stack.pop();
			}
			
			res[i] = stack.isEmpty()?-1:stack.peek();
			stack.push(arr[i]);
			
		}	
		
		return res;
	}

}
