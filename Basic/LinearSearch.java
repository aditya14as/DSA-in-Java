package com.aditya.Basic;

public class LinearSearch {
    public static void main(String[] args){
        int[] arr={12,34,52,-12,35,60,100,45};
        int target = 199;
        int ans = linearS(arr,target);
        System.out.println(ans);
    }
    static int linearS(int arr[],int target){
        if(arr.length==0){
            return -1;
        }
        for (int i = 0; i <arr.length; i++) {
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
}
