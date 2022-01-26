package com.aditya.Basic;

public class MinimumNO {
    public static void main(String[] args){
        int[] arr = {1,2,31,12,3,12,21,12,12,1,9,32,-1,222,32,1212,12};
        System.out.println(min(arr));
    }
    static int min(int[] arr){
        int ans=  arr[0];
        for (int i = 1; i <arr.length; i++) {
            if(ans>arr[i]){
                ans=arr[i];
            }
        }
        return ans;
    }
}
