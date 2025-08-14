package com.test;

public class MinumumDeletion {
    public static void main(String[] args) {
        String S ="BAAABAB";
        int numB = 0;
        int min = 0;
        for (int i=0;i<S.length();i++) {
            if(S.charAt(i) == 'A') {
                min = Math.min(numB, min+1);
            } else {
                numB++;
            }
        }
        System.out.println(min);
    }
}
