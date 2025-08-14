package com.test;

public class MaximimumSqaureWithTiles {
    public static void main(String[] args) {
        int length=0;
        int M=5,N=1;
        int x= (int) Math.sqrt(4*N +M);
        if(x %2 == 0) {
            length = x;
        } else {
            int inter = ((x-1) * (x-1))/ 4;
            if (4 * Math.min(inter, N) +M >= x*x) {
                length = x;
            }
            else {
                length = x-1;
            }
        }
        System.out.println(length);
    }
}
