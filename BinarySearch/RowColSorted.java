package com.aditya.BinarySearch;

import java.util.Arrays;

public class RowColSorted {
    public static void main(String[] args){
        int[][] arr= {
                {10,20,30,40},
                {15,25,35,45},
                {16,26,36,46},
                {17,27,37,47}

        };
        int target = 37;
        int[] ans=search(arr,target);
        System.out.println(Arrays.toString(ans));
    }

    static int[] search(int[][] matrix,int target){
        int row = 0;
        int col = matrix[0].length-1;
        while(row<matrix.length && col>=0){
            if(matrix[row][col]==target){
                return new int[] {row,col};
            }
            if(matrix[row][col]<target){
                row++;
            }
            else{
                col--;
            }
        }
        return new int[]{-1,-1};
    }
}
