package com.aditya.Backtracking;

public class LeetcodeSudoku {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},};
        solveSudoku(board);
    }
    static void solveSudoku(char[][] board) {
        if (solve(board)) {
            display(board);
        } else {
            System.out.println("Cannot solve");
        }

    }
    static void display(char[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    static boolean isSafe(char[][] board,int row, int col ,int number){
        for(int i =0; i<9; i++){
            if(board[i][col]==number){
                return false;
            }
        }
        for(int i =0; i<9; i++){
            if(board[row][i]==number){
                return false;
            }
        }
        int rowStart = row - row%3;
        int colStart = col - col%3;
        for(int i = rowStart; i<rowStart+3; i++){
            for(int j = colStart; j<colStart+3; j++){
                if(board[i][j]==number){
                    return false;
                }
            }
        }
        return false;
    }
    static boolean solve(char[][] board){
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                if(board[i][j]=='.'){
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if(isEmpty == false){
                break;
            }
        }
        if(isEmpty == true){
            return true;
        }

        for(int i =1; i<=9; i++){
            if(isSafe(board,row,col,i)){
                board[row][col] = 'i';
                if(solve(board)){
                    return true;
                }
                else{
                    board[row][col] = '.';
                }
            }
        }

        return false;
    }
}