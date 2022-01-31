package com.aditya.Backtracking;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = new int[][]{
            { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
            { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
            { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
            { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
            { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
            { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
            { 0, 0, 5, 2, 0, 6, 3, 0, 0 }};
        if (solve(board)) {
            display(board);
        } else {
            System.out.println("Cannot solve");
        }
    }
    static boolean solve(int[][] board){
        int row = -1;
        int col = -1;
        int n = board.length;
        boolean emptyLeft = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]==0){
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            if(emptyLeft== false){
                break;
            }
        }
        if(emptyLeft == true){
            return true;
            //Soduko solved
        }
        for (int i = 1; i <= board.length; i++) {
            if (isSafe(board,row,col,i)){
                board[row][col]= i;
                if(solve(board)){
                    //found answer
                    return true;
                }else{
                    board[row][col]=0;
                }

            }
        }
        return false;
    }
    static void display(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    static boolean isSafe(int[][] board, int row, int col,int number){
        for(int i =0; i<board.length; i++){
            if(board[row][i]==number){
                return false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            if(board[i][col]==number){
                return false;
            }
        }
        int sqrt = (int)(Math.sqrt(board.length));
        int Rstart = row - row%sqrt;
        int Cstart = col - col%sqrt;
        for(int i = Rstart; i< Rstart+sqrt; i++){
            for (int j = Cstart; j < Cstart+sqrt; j++) {
                if(board[i][j]==number){
                    return false;
                }
            }
        }
        return true;
    }
}
