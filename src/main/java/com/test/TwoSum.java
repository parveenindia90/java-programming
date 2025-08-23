package com.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int [] arr = {2,7,11,15};
        int targetSum = 9;

        int[] resArr = solution(arr, targetSum);
        for (int j : resArr) {
            System.out.println(j);
        }

    }

    public static int[] solution(int[] arr, int targetSum) {
        Map<Integer, Integer> sumMap= new HashMap<>();
        int[] resArr = new int[2];
        for (int i=0;i<arr.length;i++) {
            int balSum = targetSum - arr[i];
            if (sumMap.containsKey(balSum)) {
                resArr[0] = sumMap.get(balSum);
                resArr[1] = i;
            } else {
                sumMap.put(arr[i], i);
            }
        }
        return resArr;
    }
}
