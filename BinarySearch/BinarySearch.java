package com.aditya.BinarySearch;

public class BinarySearch {
    public static void main(String[] args){
        int[] arr={400,298,240,216,180,170,149,70,40,20,10};
        int target = 70;
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
        while(start<end){
            if(arr[start]==target){
                return start;
            }
            if(arr[end]==target){
                return end;
            }
            int mid= start+(end-start)/2; // Because (start+end)/2 might exceeds integer length
            if(arr[mid]==target){
                return mid;
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
        return -1;

    }
}
