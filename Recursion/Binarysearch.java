package com.aditya.Recursion;

public class Binarysearch {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,99,109,119};
        int target = 100;
        System.out.println(BS(arr,target,0,arr.length-1));
    }
    static int BS(int[] arr, int target, int start , int end){
        if(start>end){
            return -1;
        }
        int mid = start+(end-start)/2;
        if(arr[mid]==target){
            return mid;
        }
        if(arr[mid]>target){
            return BS(arr, target,start,mid-1);
        }
        return BS(arr,target,mid+1,end);
    }
}
