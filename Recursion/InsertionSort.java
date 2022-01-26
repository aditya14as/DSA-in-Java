package com.aditya.Recursion;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args){
        int[] arr = {1,7,8,9,6,5};
        insertion(arr,0,1);
        System.out.println(Arrays.toString(arr));
    }
    static void insertion(int[] arr, int row, int col){
        if(row == arr.length-1){
            return;
        }
        if(col>0){
            if(arr[col]<arr[col-1]){
                int temp = arr[col];
                arr[col] = arr[col-1];
                arr[col-1]= temp;
            }
            if(arr[col]>arr[col-1]){
                insertion(arr,row+1,col+1);
            }
            insertion(arr,row,col-1);
        }
        insertion(arr,row+1,col+1);
    }
}
