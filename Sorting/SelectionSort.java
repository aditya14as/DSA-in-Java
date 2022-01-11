package com.aditya.Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args){
        int[] arr = {9,8,7,6,5,4,3,2,1};
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selection(int[] arr){
        for(int i = 0; i< arr.length;i++){
            int end = arr.length-1-i;
            int maxIndex = findMax(arr,0,end);
            swap(arr,maxIndex,end);
        }
    }

    static int findMax(int[] arr,int start, int end){
        int max= start;
        for(int i = start;i<=end;i++){
            if(arr[i]>arr[max]){
                max = i;
            }
        }
        return max;
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
