package com.test;

public class SudokuProblem {

	public static void main(String[] args) {
		int[][] board = new int[][] {
            { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
            { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
            { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
            { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
            { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
            { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
            { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
        int N = board.length;
 
        if (solveSudoku(board, N))
        {
            for(int i=0;i<N;i++){
            	for(int j=0;j<N;j++){
            		System.out.print(" " + board[i][j] + " ");
                }
            	System.out.println();
            }
        }
        else {
            System.out.println("No solution");
        }

	}

	private static boolean solveSudoku(int[][] board, int n) {
		
		int row = -1;
		int column = -1;
		boolean isFull = true;
		
		for(int i=0;i<n;i++){
        	for(int j=0;j<n;j++){
        		if(board[i][j] == 0){
        			row = i;
        			column = j;
        			isFull = false;
        			break;
        		}
            }
        }
		
		//no empty space left
		if(isFull)
			return true;
		
		for(int i=1;i<=9;i++){
			
			if(isSafe(board,row,column,i)){
				board[row][column] = i;
				if(solveSudoku(board,n)){
					return true;
				}
				board[row][column] = 0;
			}
			
		}
		
		return false;
	}

	private static boolean isSafe(int[][] board, int row, int col, int num) {
		
		//check in row
		for(int i=0;i<board.length;i++){
			if(board[i][col] == num)
				return false;
		}
		
		//check in column 
		for(int i=0;i<board.length;i++){
			if(board[row][i] == num)
				return false;
		}
		
		//check in 3*3 box
		int sqrt = (int) Math.sqrt(board.length);
		int boxRowStart = row - row % sqrt;
		int boxColStart = col - col % sqrt;
		
		for(int i=boxRowStart;i<boxRowStart+sqrt;i++){
			for(int j=boxColStart;j<boxColStart+sqrt;j++){
				if(board[i][j] == num)
					return false;
			}
		}
		
		
		return true;
	}

}
