package com.test;

public class RemoveANumberInplaceArray {
    //Given an integer array input and an integer val, remove all occurrences of val in input in-place

    public static void main(String[] args) {
        int[] input = {3, 2, 2, 0, 1, 9, 0, 3, 7};
        //output should be // {2,2,0,1,9,0,7,-,-} // last 2 elements will not be considered
        int k = solution(input, 3);
        for (int i =0; i<k; i++) {
            System.out.println(input[i]);
        }
    }

    public static int solution(int[] input, int val) {
        int k= 0;
        for (int num : input) {
            if (num != val) {
                input[k++] = num;
            }
        }
        return k;
    }

}
