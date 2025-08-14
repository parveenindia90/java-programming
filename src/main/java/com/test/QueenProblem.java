package com.test;

public class QueenProblem {

	final int N =4;
	public static void main(String[] args) {
		QueenProblem queen = new QueenProblem();
        queen.solveNQ();
	}

	private boolean solveNQ() {
		int[][] board = new int[N][N];
		if(!solveQueenProblem(board,0)){
			System.out.println("Soltion does not exists");
			return false;
		}
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(" "+board[i][j]+" ");
			}
			System.out.println();
		}
		return true;
		
	}

	private boolean solveQueenProblem(int[][] board, int row) {
		if(row == N){
			return true;
		}
		
		for(int i=0;i<N;i++){
			if(isSafe(board,row,i)){
				board[row][i] = 1;
				if(solveQueenProblem(board,row+1)){
					return true;
				}
				board[row][i] = 0;
			}
		}
		
		
		return false;
	}

	private boolean isSafe(int[][] board, int row, int col) {
		//check left side in the row
		for(int i=0;i<row;i++){
			if(board[i][col] ==1){
				return false;
			}
		}
		
		//check upper left diagonal
		for(int i=row,j=col;i>=0 && j>=0;i--,j--){
			if(board[i][j] ==1){
				return false;
			}
		}
		
		//check upper right diagonal
		for(int i=row,j=col;i>=0 && j<N;i--,j++){
			if(board[i][j] ==1){
				return false;
			}
		}
		
		return true;
	}

	
}
