package com.aditya.BinarySearch;

public class IsPerfectSquare {
    public static void main(String[] args){
        System.out.println(isPerfectSquare(5));
    }
        static boolean isPerfectSquare(int num) {
            if(num<2){
                return true;
            }
            int start = 1;
            int end = num;
            while(start<=end){
                int mid = start+(end-start)/2;
                if(mid*mid == num/mid){
                    return true;
                }
                if(mid*mid <num){
                    start = (int)mid+1;
                }
                else{
                    end = (int)mid-1;
                }
            }
            return false;
        }

}
