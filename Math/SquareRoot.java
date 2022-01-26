package com.aditya.Math;

public class SquareRoot {
    public static void main(String[] args) {
        System.out.printf("%.3f",squareRoot(40,3));
    }
    static double squareRoot(int n,int length){
        int start = 1;
        int end = n/2;
        double root=0;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(mid*mid == n){
                root = mid;
            }
            else if(mid*mid<n){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }

        double inc = 0.1;
        for(int i =0; i<length; i++){
            while(root*root<= n){
                root+=inc;
            }
            root = root-inc;
            inc = inc/10;
        }
        return root;
    }
}
