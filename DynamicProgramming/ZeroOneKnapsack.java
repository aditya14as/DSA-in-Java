package com.aditya.DynamicProgramming;

import java.util.Arrays;

public class ZeroOneKnapsack {
    //Type-1 https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1#
    class Solution
    {
        static int[][] dp = new int[1001][1001];
        Solution(){
            for(int i =0;i<dp.length; i++){
                Arrays.fill(dp[i],-1);
            }
        }
        //Function to return max value that can be put in knapsack of capacity W.
        static int knapSack(int W, int wt[], int val[], int n)
        {
            // your code here
            if(n==0 || W==0){
                return 0;
            }
            if(dp[n][W] !=-1){
                return dp[n][W];
            }
            if(wt[n-1]>W){   // if wt array have value greater than the maximum weight then ignore this one
                return dp[n][W]= knapSack(W,wt,val,n-1);
            }
            else{ //return maximum value after taking a particular element and after ignoring a particular element
                return dp[n][W]=Math.max( val[n-1] + knapSack(W-wt[n-1],wt,val,n-1) , knapSack(W,wt,val,n-1));
            }
        }
    }

    //Type-2 https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1/
    class Solution2{
        static int[][] dp = new int[101][100001];
        Solution2(){
            for(int i =0;i<dp.length; i++){
                Arrays.fill(dp[i],-1);
            }
        }

        static Boolean isSubsetSum(int N, int arr[], int sum){
            // code here
            int a = solve(N,arr,sum);
            if(a==0){
                return false;

            }
            else{
                return true;
            }
        }
        static int solve(int n, int arr[], int sum){
            if(n==0 && sum==0){  // if sum is equal to zero then answer would be 1 because we can take empty set
                return 1;
            }
            if(sum==0){
                return 1;
            }
            if(n==0 && sum!=0){ // if n == 0 means no item in arr but sum is not equal to zero then it's not possible to create
                                // that array with sum greater than 0
                return 0;
            }
            if(dp[n][sum] !=-1){
                return dp[n][sum];
            }


            if(arr[n-1]>sum){ // If element of array is greater than sum then we can't take that element in the sum by any means
                return dp[n][sum] = solve(n-1,arr,sum); //
            }else{
                int a = solve(n-1, arr, sum-arr[n-1]); // Taking that element in the sum
                int b = solve(n-1, arr, sum); // Not taking that element in the sum
                if(a==1 || b==1){   // if any of the options is returning true then whole answer would be true
                    return dp[n][sum]=1;
                }else{
                    return dp[n][sum]=0;
                }
            }
        }
    }
}
