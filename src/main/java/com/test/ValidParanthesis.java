package com.test;

import java.util.Stack;

public class ValidParanthesis {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                if ((c == ')' && stack.peek() != '(') ||
                        (c == '}' && stack.peek() != '{') ||
                        (c == ']' && stack.peek() != '[')) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}

