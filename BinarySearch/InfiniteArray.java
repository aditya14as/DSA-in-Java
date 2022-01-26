package com.aditya.BinarySearch;

public class InfiniteArray {
    public static void main(String[] args){
        int[] arr={1,2,3,4,5,62,90,100,200,300,400,500,700,800,801,901,902,903,904,905,906,907,908,909,910,911};
        int target = 901;
        int start=0;
        int end=2;

        while(target>arr[end]){
            int newstart = end+1;
            end = end+(end-start+1)*2;
            start=newstart;
        }

        int ans= BinarySearch(arr,target,start,end);
        System.out.println(ans);

    }

    static int BinarySearch(int[] arr,int target,int start,int end){
        while(start<=end){
            int mid = start+(end-start)/2;
            if(target<arr[mid]){
                end = mid-1;
            }
            else if(target>arr[mid]){
                start = mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }

}
