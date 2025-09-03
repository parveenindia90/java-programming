package com.test;

public class ArrayProblem {

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3, 4};
        int count = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            count++;
            if (arr[i] < arr[i - 1]) {
                break;
            }
        }
        System.out.println(count);
    }
}
