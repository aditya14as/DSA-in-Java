package com.aditya.Recursion.Practice;

import java.util.ArrayList;
import java.util.Arrays;

public class SumTriangle {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        sum(arr);
    }
    static void sum(int[] arr){
        if(arr.length==1){
            System.out.println(Arrays.toString(arr));
            return;
        }

        int[] arr1 = new int[arr.length-1];
        for (int i = 0; i < arr.length-1; i++) {
            arr1[i] = arr[i]+arr[i+1];
        }
        sum(arr1);
        System.out.println(Arrays.toString(arr));
    }
}
