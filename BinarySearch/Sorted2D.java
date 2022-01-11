package com.aditya.BinarySearch;

import java.util.Arrays;

public class Sorted2D {
    public static void main(String[] args){
        int[][] arr= {
                {10,20,30,40},
                {41,42,43,45},
                {46,47,48,49},
                {50,51,52,53}

        };
        int target = 45;
        int[] ans=search(arr,target);
        System.out.println(Arrays.toString(ans));
    }
    static int[] search(int[][] matrix,int target){
        int row = matrix.length;
        int col= matrix[0].length;
        int start=0;
        int end = row*col-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(matrix[mid/col][mid%col]==target){
                return new int[] {mid/col,mid%col};
            }
            if(matrix[mid/col][mid%col]<target){
                start=mid+1;
            }
            else{
                end= mid-1;
            }
        }
        return new int[] {-1,-1};
    }
}
