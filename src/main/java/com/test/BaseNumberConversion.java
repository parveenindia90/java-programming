package com.test;

public class BaseNumberConversion {

    public static void main(String[] args) {
        String str = Integer.toString(Integer.parseInt("10", 10), 5);
        System.out.println(str);
    }
}
