package com.aditya.BinarySearch;

public class RotatedBSwithDuplicates {
    public static void main(String[] args){
        int[] arr={2,2,4,5,6,0,1,2,2};
        int pivot = findPivotWithDuplicate(arr);
        System.out.println(pivot);
    }
    static int findPivotWithDuplicate(int[] arr){
        int start = 0;
        int end = arr.length;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(start>mid && arr[mid-1]>arr[mid]){
                return mid-1;
            }
            if(end>mid && arr[mid]>arr[mid+1]){
                return mid;
            }
            // If element at middle,start, end are equal then just skip the duplicates
            if(arr[mid] == arr[start] && arr[mid] == arr[end]){
                // skip the duplicates
                // check if start is pivot or not
                if(arr[start]>arr[start+1]){
                    return start;
                }
                start++;
                // check if end is pivot or not
                if(arr[end-1]>arr[end]){
                    return end;
                }
                end--;
            }
            // left side is sorted, so pivot should be in right
            else if(arr[start] < arr[mid] || (arr[start]==arr[mid] && arr[mid] > arr[end])){
                start = mid+1;
            }
            else{
                end = mid-1;
            }

        }
        return -1;
    }
}
