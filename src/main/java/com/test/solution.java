package com.test;

import java.util.Scanner;

class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int n = 0; n < t; n++) {
            String str = sc.nextLine();
            String[] arr = str.split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            int c = Integer.parseInt(arr[2]);
            while(a > 0 && b > 0 && c > 0){
            	if(a > b && a > c)
                {
            		a = a-2;
            		b = b-1;
            		c = c-1;
                }
                else if(b > c)
                {
                	a = a-1;
            		b = b-2;
            		c = c-1;
                }
                else
                {
                	a = a-1;
            		b = b-1;
            		c = c-2;
                }
            }
            
            if(a == 0 && b == 0 && c == 0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }

    }
}