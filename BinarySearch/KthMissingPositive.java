package com.aditya.BinarySearch;

public class KthMissingPositive {
    public static void main(String[] args){
        int[] arr = {2,3,4,7,11};
        int k = 3;
        System.out.println(findKthPositive(arr,k));
    }
    static int findKthPositive(int[] arr, int k) {
        int start = 0;
        int end = arr.length-1;
        while(start<= end){
            int mid = start + (end-start)/2;
            int missingno = missingNo(arr[mid],mid);
            if(k==missingno){
                return arr[mid]-1;
            }
            if(k>missingno){
                start = mid+1;
            }
            else{
                end = mid-1;
            }

        }
        if(end == -1){
            return arr[0]-1+(k-missingNo(arr[0],0));
        }
        return arr[end]+(k-missingNo(arr[end],end));
    }

    static int missingNo(int no, int index){
        int actual = no-(index+1);
        return actual;
    }
}
