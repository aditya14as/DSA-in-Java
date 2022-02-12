package com.aditya.Backtracking;

import java.util.*;

public class SudokuPractice {
    public static void display(int[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void solveSudoku(int[][] grid, int i, int j) {
        // write yopur code here
        if(i==grid.length){
            display(grid);
            return;
        }
        int ni=0;
        int nj=0;
        if(j==grid[0].length-1){
            ni=i+1;
            nj=0;
        }else{
            ni=i;
            nj=j+1;
        }
        if(grid[i][j]!=0){
            solveSudoku(grid,ni,nj);
        }else{
            for(int po=1;po<=9;po++){
                if(isValid(grid,i,j,po)==true){
                    grid[i][j]=po;
                    solveSudoku(grid,ni,nj);
                    grid[i][j]=0;
                }
            }
        }
    }
    static boolean isValid(int[][] grid,int row,int col, int value){
        for(int i=0; i<grid[0].length;i++){
            if(grid[row][i]==value){
                return false;
            }
        }
        for(int i=0; i<grid.length;i++){
            if(grid[i][col]==value){
                return false;
            }
        }
        int rs=3*(row/3);
        int cs = 3*(col/3);
        for(int i=rs;i<(rs+3);i++){
            for(int j=cs;j<(cs+3);j++){
                if(grid[i][j]==value){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
//        int[][] arr = new int[][]{ {3, 0, 6, 5, 0, 8, 4, 0, 0},
//
//            {5, 2, 0, 0, 0, 0, 0, 0, 0},
//
//            {0, 8, 7, 0, 0, 0, 0, 3, 1},
//
//            {0, 0, 3, 0, 1, 0, 0, 8, 0},
//
//            {9, 0, 0, 8, 6, 3, 0, 0, 5},
//
//            {0, 5, 0, 0, 9, 0, 6, 0, 0},
//
//            {1, 3, 0, 0, 0, 0, 2, 5, 0},
//
//            {0, 0, 0, 0, 0, 0, 0, 7, 4},
//
//            {0, 0, 5, 2, 0, 6, 3, 0, 0} };
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        solveSudoku(arr, 0, 0);
    }
}
