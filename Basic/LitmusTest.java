package com.aditya.Basic;

import java.util.Scanner;

public class LitmusTest {
    public static void main(String args[]) {
        // Your code goes here
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        int[] arr = new int[p];
        for(int i=0; i<p; i++){
            arr[i] = in.nextInt();
        }
        int n = in.nextInt();
        int m = in.nextInt();
        System.out.println(helper(p,arr,n,m));
    }
    static int helper(int p, int[] arr, int n, int m){
        int ans=0;
        int sum = 0;
        for(int i=0; i<p; i++){
            sum = sum +arr[i];
            if(sum>=n){
                ans = ans+1;
                sum = 0;
                i= i-1;
            }
        }
        return ans;
    }
}

