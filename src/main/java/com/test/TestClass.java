package com.test;
import java.util.ArrayList;
import java.util.List;
 
public class TestClass {
 
    // Function to print in spiral order
    public static List<Integer> spiralOrder(int[][] matrix)
    {
        List<Integer> ans = new ArrayList<>();
 
        if (matrix.length == 0)
            return ans;
 
        int R = matrix.length, C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        int[] dr = { 0, 1, 0, -1 };
        int[] dc = { 1, 0, -1, 0 };
        int r = 0, c = 0, di = 0;
 
        // Iterate from 0 to R * C - 1
        for (int i = 0; i < R * C; i++) {
        	ans.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
 
            if (0 <= cr && cr < R && 0 <= cc && cc < C
                && !seen[cr][cc]) {
                r = cr;
                c = cc;
            }
            else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return ans;
    }
 
    // Driver Code
    public static void main(String[] args)
    {
        int a[][] = { { 1, 2, 3, 4 ,5},
                      { 5, 6, 7, 8 ,0},
                      { 9, 10, 11, 12,9 },
                      { 13, 14, 15, 16 ,5},
                      { 13, 14, 15, 17 ,7}};
 
        System.out.println(spiralOrder(a));
    }
}