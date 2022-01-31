package com.aditya.Backtracking;

public class NKnights {
    public static void main(String[] args) {
        int n = 3;
        boolean[][] board= new boolean[n][n];
        nKnights(board,0,0,n);
    }
    static void display(boolean[][]arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j]){
                    System.out.print("K ");
                }else{
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
    static void nKnights(boolean[][] arr, int row, int col,int target){
        if(target == 0){
            display(arr);
            System.out.println();
            return;
        }
        if(row == arr.length-1 && col== arr.length){
            return;
        }
        if(col == arr.length){
            nKnights(arr,row+1,0,target);
            return;

        }

        if(isSafe(arr,row,col)){
            arr[row][col] = true;
            nKnights(arr,row,col+1,target-1);
            arr[row][col] = false;
        }
        nKnights(arr,row,col+1,target);
    }
    static boolean isSafe(boolean[][] arr, int row, int col){
        if(isValid(arr,row-1,col-2)){
            if(arr[row-1][col-2]){
                return false;
            }
        }
        if(isValid(arr,row-2,col-1)){
            if(arr[row-2][col-1]){
                return false;
            }
        }
        if(isValid(arr,row-1,col+2)){
            if(arr[row-1][col+2]){
                return false;
            }
        }
        if(isValid(arr,row-2,col+1)){
            if(arr[row-2][col+1]){
                return false;
            }
        }
        return true;
    }
    static boolean isValid(boolean[][] arr, int row, int col){
        if(row>=0 && row <arr.length && col>=0 && col<arr.length){
            return true;
        }
        return false;
    }
}
