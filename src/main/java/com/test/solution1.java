package com.test;

import java.util.Scanner;

public class solution1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int testCase = 0; testCase < t; testCase++) {
            int len = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            String s = sc.next();
            
            int m = (2*n) +1;
            int p = (4*n*k) +1;
        	char [][]a = new char[m][p];
        	char []c = s.toCharArray();
         
            int row = n;		
        	boolean down = false;
        	int pos=0;
        	for (int i = 0; i < len; i++)
        	{
        		a[row][pos] = c[i];
        		if (row == 0)
        			down = true;
        		if(row == m-1)
        			down = false;
        		if(down)
        			row++;
        		else
        			row--;
        		
        		pos++;
        		
        		if(i == len-1){
        			i = -1;
        		}
        		
        		
        		if(pos == p){
        			break;
        		}
        	}
        	
        	for (int i = 0; i < m; i++)
        	{
        		for (int j = 0; j < p; j++)
        		{
        			System.out.print(a[i][j] + " ");
        		}
        		System.out.println();
        	}
            
            
        }

    }
}