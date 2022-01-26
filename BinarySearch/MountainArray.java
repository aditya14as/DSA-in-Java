package com.aditya.BinarySearch;

public class MountainArray {
    public static void main(String[] args){
        int[] arr = {0,1,2,3,4,2,1};
        int target =3;
        int ans=-1;
        int peak = peakFind(arr);
        if(arr[peak]==target){
            ans=peak;
        }
        ans = binarySearch(arr,target,0,peak-1);
        if(ans==-1){
            ans=binarySearch(arr,target,peak+1,arr.length-1);
        }
        System.out.println(ans);
    }
    static int peakFind(int[] arr){
        int start = 0;
        int end=arr.length-1;
        while(start<end){
            int mid= start+(end-start)/2;
            if(arr[mid]<arr[mid+1]){
                start=mid+1;
            }
            else{
                end = mid;
            }
        }
        return start;
    }
    static int binarySearch(int[] arr,int target,int start,int end){

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
