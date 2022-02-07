package com.aditya.Backtracking;

import java.util.ArrayList;
import java.util.List;

import static com.aditya.Backtracking.NQueens.display;

public class NQueensLeetCode {
    public static void main(String[] args) {
        int n= 4;
        boolean[][] arr = new boolean[n][n];
        nQueens(arr,0);
    }
    static void nQueens(boolean[][] arr,int row){
        List<List<String>> ans = new ArrayList<>();
        if(row==arr.length){
            List<String> inner = new ArrayList<>();
            String str;
            for (int i = 0; i < arr.length; i++) {
                str = "";
                for (int j = 0; j < arr[0].length; j++) {
                    if(arr[i][j]){
                        str = str + 'Q';
                    }
                    else{
                        str = str + '.';
                    }
                }
                inner.add(str);
            }
            ans.add(inner);
            return;
        }

        for(int col=0; col< arr[0].length;col++){
            if(isValid(arr,row,col)){
                arr[row][col] =true;
                nQueens(arr,row+1);
                arr[row][col] = false;
            }
        }
    }
    static boolean isValid(boolean[][] arr,int row,int col){
        for(int i =0; i<arr.length; i++){
            if(arr[i][col]){
                return false;
            }
        }
        int maxLeft = Math.min(row,col);
        for (int i = 1; i <= maxLeft; i++) {
            if(arr[row-i][col-i]){
                return false;
            }
        }
        int maxRight = Math.min(row,arr.length-1-col);
        for (int i = 1; i <= maxRight; i++) {
            if(arr[row-i][col+i]){
                return false;
            }
        }
        return true;
    }
}
