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

    // Type 3: https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1#
    class Solution3{

        static int equalPartition(int N, int arr[])
        {
            // code here
            int sum = 0;
            for(int i=0; i<arr.length; i++){
                sum+= arr[i];
            }
            if(sum%2!=0){ // If sum is odd then we can't divide in equal subset sum by any means
                return 0;
            }else{
                int[][] dp= new int[N+1][sum/2+1];
                for(int i=0; i<dp.length; i++){
                    Arrays.fill(dp[i],-1);
                }
                return solve(N,arr,sum/2,dp); //If any subset contains sum/2 then half of it will also be there because sum is even
            }
        }

        static int solve(int n, int arr[], int sum,int[][] dp){
            if(n==0 && sum==0){  // if sum is equal to zero then answer would be 1 because we can take empty set
                return 1;
            }
            if(sum==0){    //It'll give wrong answer if arr[0] is 0 because code will return from arr[1] as 1 but in reality
                           // answer is 2 because first element in zero we can take it or not take it in either case subset is true
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
                dp[n][sum] = solve(n-1,arr,sum,dp);
                return dp[n][sum];
            }else{
                int a = solve(n-1, arr, sum-arr[n-1],dp); // Taking that element in the sum
                int b = solve(n-1, arr, sum,dp); // Not taking that element in the sum
                if(a==1 || b==1){   // if any of the options is returning true then whole answer would be true
                    return dp[n][sum]=1;
                }else{
                    return dp[n][sum]=0;
                }
            }
        }
    }

    //Type 4:- https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1#
    class Solution4{
        static int M=1000000007;
        public int perfectSum(int arr[],int n, int sum)
        {
            // Your code goes here
            int[][] dp = new int[n+1][sum+1];
            for(int i =0; i<dp.length; i++){
                Arrays.fill(dp[i],-1);
            }
            return solve(arr,n,sum,dp);
        }
        public int solve(int[] arr, int n, int sum, int[][] dp){
            if(n==0 && sum==0){  // if sum is equal to zero then answer would be 1 because we can take empty set
                return 1;
            }
            if(n==0){
                return 0;
            }

            if(dp[n][sum] != -1){
                return dp[n][sum]%M;
            }

            if(arr[n-1]>sum){
                return dp[n][sum]= solve(arr,n-1,sum,dp)%M;
            }else{
                return dp[n][sum] = (solve(arr,n-1,sum-arr[n-1],dp)%M + solve(arr,n-1,sum,dp)%M) % M;
            }

        }
    }
    // Type 5:- https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1/#
    class Solution5
    {

        public int minDifference(int arr[], int n) {
            // Your code goes here

            int sum = 0;
            for(int i=0; i<arr.length; i++){
                sum+= arr[i];
            }

            boolean[][] dp= new boolean[n+1][sum+1];

            for (int i = 0; i <= n; i++) dp[i][0] = true;
            for (int i = 1; i <= sum; i++) dp[0][i] = false;

            for(int i = 1; i < n+1; i++){  //Filling the dp matrix using tabulation
                                            //Just replace the n with i and sum with j from the recursive call as we have did earlier
                                            // dp table is filled
                for(int j = 1; j < sum+1; j++){
                    if(arr[i-1] <= j)
                        dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                    else
                        dp[i][j] = dp[i-1][j];
                }
            }
            int diff = Integer.MAX_VALUE;
            for (int j = sum / 2; j >= 0; j--) {
                if (dp[n][j] == true) {
                    diff = sum - 2 * j; //For S1-S2 should be minimum(S1>S2), S2=Sum of array -s1
                                        // By using above all S1-S2 = Sum-2*S1. For positive value we can take only sum/2 to 0
                                        //Minimum difference is The first value of j having True in dp matrix starting from sum/2 in last row
                    break;
                }
            }
            return diff;
        }

    }

    // Type 6:- https://leetcode.com/problems/target-sum/
    // This is also the problem of count the number of subset with a given difference
    //No of subset so that S1-S2 ==d  -----eqn1
    // S1+S2 = sum of array ------eqn2
    // using eqn 1 and 2 we get S1 = (d+Sum)/2
    // if d+sum is odd then return 0 because in this case s1 will be in fraction which is not possible by any means
    // this leetcode problem is same just distroted a little bit.
    // We can take all possible S1 with positive sign and S2 with negative sign
    class Solution6 {
        public int findTargetSumWays(int[] nums, int target) {
            int sum =0;
            for(int i=0; i<nums.length; i++){
                sum+=nums[i];
            }
            int s= (sum+target)/2;
            if(sum+target<0 || (sum+target)%2 ==1) return 0; //If sum+target is odd then return 0 because in this case s is in fraction

            int[][] dp = new int[nums.length+1][s+1];
            for(int i=0; i<dp.length; i++){
                Arrays.fill(dp[i],-1);
            }
            return solve(nums,s,nums.length,dp);
        }

        public int solve(int[] arr, int sum,int n,int[][] dp){
            if(n==0 && sum==0){
                return 1;
            }
            if(n==0){
                return 0;
            }
            if(dp[n][sum] != -1){
                return dp[n][sum];
            }
            if(arr[n-1]>sum){
                return dp[n][sum] = solve(arr,sum,n-1, dp);
            }else{
                return dp[n][sum] = solve(arr,sum,n-1,dp) + solve(arr,sum-arr[n-1],n-1,dp);
            }
        }
    }

}
