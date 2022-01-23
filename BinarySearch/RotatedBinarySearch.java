package com.aditya.BinarySearch;

public class  RotatedBinarySearch {
    public static void main(String[] args){
        int[] arr = {1,3,5};
        int target = 5;
        System.out.println(search(arr,target));
    }
    static int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        int ans;
        if(pivot==-1){
            ans=BinarySearch(nums,target,0,nums.length-1);
            return ans;
        }
        if(pivot!=-1 && nums[pivot]==target){
            return pivot;
        }
        ans = BinarySearch(nums,target,0,pivot-1);
        if(ans== -1){
            ans = BinarySearch(nums,target,pivot+1,nums.length-1);
        }
        return ans;

    }

    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(mid<end && arr[mid]>arr[mid+1] ){
                return mid;
            }
            else if(mid>start && arr[mid-1]>arr[mid]){
                return mid-1;
            }
            else if(arr[start]>=arr[mid]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }
    static int BinarySearch(int[] arr, int target, int start, int end){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]<target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }
}
