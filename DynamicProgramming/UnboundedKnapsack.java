package com.aditya.DynamicProgramming;

import java.util.Arrays;

public class UnboundedKnapsack {
    //Type 1: https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1/
    class Solution{
        static int[][] dp = new int[1001][1001];
        Solution(){
            for(int i =0; i<dp.length; i++){
                Arrays.fill(dp[i], -1);
            }
        }
        static int knapSack(int n, int w, int val[], int wt[])
        {
            // code here
            if(n==0 || w==0){
                return 0;
            }
            if(dp[n][w] != -1){
                return dp[n][w];
            }

            if(wt[n-1]>w){
                return dp[n][w] = knapSack(n-1,w,val,wt);
            }else{ //Only difference from 01Knapsack is that when we take it earlier we decrease n-1 but here we leave as it
                // is when we take it because a single element can be taken multiple no of times
                return dp[n][w]=Math.max( val[n-1] + knapSack(n,w-wt[n-1],val,wt) , knapSack(n-1,w,val,wt));
            }

        }
    }

    //Type 2: https://practice.geeksforgeeks.org/problems/rod-cutting0840/1/
    // Same as type 1 but here weight arr is not given
    class Solution2{
        public int cutRod(int price[], int n) {
            //code here

            int[][] dp = new int[n+1][n+1];
            for(int i =0; i<dp.length; i++){
                Arrays.fill(dp[i], -1);
            }
            return helper(price,n,n,dp);
        }
        public int helper(int[] price, int n, int l, int[][] dp){
            if(n==0 || l==0) return 0;
            if(dp[n][l] != -1){
                return dp[n][l];
            }
            if(n-1<l){
                return dp[n][l] = Math.max(price[n-1] + helper(price,n,l-n,dp) , helper(price,n-1,l,dp));
            }else{
                return dp[n][l] = helper(price,n-1,l,dp);
            }
        }
    }

    // Type 3: https://practice.geeksforgeeks.org/problems/coin-change2448/1
    class Solution3 {
        public long count(int S[], int m, int n) {
            // code here.
            long[][] dp = new long[m+1][n+1];
            for(int i =0; i<dp.length; i++){
                Arrays.fill(dp[i], -1);
            }

            return helper(S,m,n,dp);
        }
        public long helper(int[] arr, int m, int n,long[][] dp){
            if(m==0 && n>0){
                return 0;
            }
            if(n==0){
                return 1;
            }
            if(dp[m][n] != -1){
                return dp[m][n];
            }
            if(arr[m-1]<=n){
                return dp[m][n] = helper(arr,m,n-arr[m-1], dp) + helper(arr,m-1,n,dp);
            }else{
                return dp[m][n] = helper(arr,m-1,n,dp);
            }
        }
    }

    //Type 4: https://practice.geeksforgeeks.org/problems/number-of-coins1824/1/
    //Warning: Revise again because this is the one of the few question in which we have to initialize two row

    class Solution4{

        public int minCoins(int coins[], int n, int v)
        {
            // Your code goes here
            int[][] dp = new int[n+1][v+1];
            for(int i =0; i<dp.length; i++){
                Arrays.fill(dp[i], -1);
            }
            int x = helper(coins, n, v, dp);
            return x==Integer.MAX_VALUE-1 ? -1 : x;
        }
        public int helper(int[] arr, int n, int v, int[][] dp){
            if(v==0 && n>0){  // if arr is not empty and val is zero then we have zero ways
                return 0;
            }
            if(n==0){ // // inf arr is not empty and val is zero then we have infinite ways
                return Integer.MAX_VALUE -1;
            }
            //We can't anything from above two condition so we have to add another base condition having 1st element of array
            if(n==1){
                if(v%arr[0] == 0){  // if val and 1st element is divisible then min no of ways is their quotient
                    return v/arr[0];
                }else{
                    return Integer.MAX_VALUE -1;
                }
            }
            if(dp[n][v] != -1){
                return dp[n][v];
            }
            if(arr[n-1]<=v){  // Here we are doing the same as we did earlier but we chooe Max_value -1 instead of Max_value
                // because if we choose either then Max_value+1 will give negative integer as it's the maximum no an int can store and our answer will be wrong
                return dp[n][v] = Math.min( helper(arr,n,v-arr[n-1], dp) +1 , helper(arr,n-1,v,dp) );
            }else{
                return dp[n][v] = helper(arr, n-1, v, dp);
            }
        }
    }
}
