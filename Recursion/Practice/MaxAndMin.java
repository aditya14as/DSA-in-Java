package com.aditya.Recursion.Practice;

public class MaxAndMin {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, -5, -4, 8, 6};
        find(arr,arr[0],arr[0],0);
    }
    static void find(int[] arr, int min, int max,int i){
        if(i==arr.length){
            System.out.println("Max: "+max+ " Min: "+min);
            return;
        }
        if(arr[i]>max){
            max=arr[i];
        }
        if(arr[i]<min){
            min = arr[i];
        }
        find(arr,min,max,i+1);
    }
}
