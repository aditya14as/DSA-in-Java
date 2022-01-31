package com.aditya.Backtracking;

public class NQueens {
    public static void main(String[] args) {
        int n = 8;
        boolean[][] board = new boolean[n][n];
        System.out.println(nQueens(board,0));
    }
    static int nQueens(boolean[][] arr,int r){
        if(r== arr.length){
            display(arr);
            System.out.println();
            return 1;
        }
        int count = 0;
        for (int col = 0; col<arr[0].length; col++){
            if(isSafe(arr,r,col)){
                arr[r][col] = true;
                count = count + nQueens(arr,r+1);
                arr[r][col] = false;
            }
        }
        return count;
    }
    static boolean isSafe(boolean[][] arr, int r, int c){
        for (int i = 0; i < r; i++) {
            if(arr[i][c]){
                return false;
            }
        }
        int maxLeft = Math.min(r,c);
        for(int i = 1; i<=maxLeft; i++){
            if(arr[r-i][c-i]){
                return false;
            }
        }
        int maxRight = Math.min(r,arr.length-c-1);
        for (int i = 1; i <= maxRight; i++) {
            if(arr[r-i][c+i]){
                return false;
            }
        }
        return true;
    }
    static void display(boolean[][]arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j]){
                    System.out.print("Q ");
                }else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
