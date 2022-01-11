package com.aditya.BinarySearch;
public class Ceiling {
    public static void main(String[] args){
        int[] arr={200,100,90,40,30,20,10};
        int target = 41;
        int ans= binarySearch(arr,target);
        System.out.println(ans);
    }
    static int binarySearch(int[] arr,int target){
        int start=0;
        int end=arr.length-1;
        boolean isOrderAgnosticBinarySearch;
        if(arr[start]<arr[end]){
            isOrderAgnosticBinarySearch=true;
        }
        else{
            isOrderAgnosticBinarySearch=false;
        }
        while(start<=end){
            if(arr[start]==target){
                return arr[start];
            }
            if(arr[end]==target){
                return arr[end];
            }
            int mid= start+(end-start)/2; // Because (start+end)/2 might exceeds integer length
            if(arr[mid]==target){
                return arr[mid];
            }

            if(isOrderAgnosticBinarySearch){
                if(arr[mid]<target){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }

            else {
                if(arr[mid]>target){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
        }
        if(isOrderAgnosticBinarySearch)
            return arr[start];
        else
            return arr[end];

    }
}
