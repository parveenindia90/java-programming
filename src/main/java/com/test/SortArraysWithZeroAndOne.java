package com.test;

import java.util.Arrays;

public class SortArraysWithZeroAndOne {

    public static void main(String[] args) {
        int[] arr = {0,1,0,1,1,0,1,0,1};
        arr = sortArray(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static int[] sortArray(int[] arr) {

        int i =0;
        int j = arr.length-1;

        while(i<j) {
            if(arr[i] >= arr[j]) {
                int val = arr[i];
                arr[i] = arr[j];
                arr[j] = val;
                j --;
            } else {
                i++;
            }
        }
        return arr;
    }
}
