package com.aditya.Basic;

import java.util.Arrays;

public class Swap {
    public static void main(String[] args){
        int[] arr= { 1,2,3,100,10,6,7};
        reverse(arr);
        System.out.println(max(arr));
    }

    static void swap(int[] arr1,int index1,int index2){
        int temp=arr1[index1];
        arr1[index1]=arr1[index2];
        arr1[index2]=temp;
    }

    static void reverse(int[] arr){
        int front=0;
        int back = arr.length-1;
        if(front<back){
            swap(arr,front,back);
            front++;
            back--;
        }
        System.out.println(Arrays.toString(arr));
    }

    static int max(int[] arr){
        int max=arr[0];
        for (int i = 1; i < arr.length ; i++) {
            if(max<arr[i])
                max=arr[i];
        }
        return max;
    }
}
