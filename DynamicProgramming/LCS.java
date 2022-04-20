package com.aditya.DynamicProgramming;

import java.util.Arrays;

public class LCS {
    // Type 1: https://leetcode.com/problems/longest-common-subsequence/

    class Solution1{
        public int longestCommonSubsequence(String S1, String S2) {
            int n = S1.length();
            int m = S2.length();
            int[][] dp = new int[n+1][m+1];
            for(int i =0; i<dp.length; i++){
                Arrays.fill(dp[i], -1);
            }

            return helper(S1,S2,n,m,dp);
        }
        int helper(String s1, String s2, int n, int m, int[][] dp){
            if(n==0 || m==0) return 0;
            if(dp[n][m] != -1){
                return dp[n][m];
            }
            if(s1.charAt(n-1) == s2.charAt(m-1)){
                return dp[n][m] = 1+ helper(s1,s2, n-1, m-1,dp);
            }else{
                return dp[n][m] = Math.max( helper(s1,s2, n-1, m, dp) , helper(s1,s2,n, m-1, dp) );
            }
        }
    }

    //Type 2: https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1#
    //Substring means continuous sub string
    // Revise again and use recursive code
    class Solution2{
        int longestCommonSubstr(String s1, String s2, int n, int m){
            // code here
            int[][] dp = new int[n+1][m+1];
            for(int i=0; i<dp.length; i++){
                for(int j=0; j<dp[0].length; j++){
                    if(i==0 || j==0){
                        dp[i][j]=0;
                    }
                }
            }

            for(int i=1; i<dp.length; i++){
                for(int j=1; j<m+1; j++){
                    if( s1.charAt(i-1) == s2.charAt(j-1) ){
                        dp[i][j] = dp[i-1][j-1]+1;
                    }else{
                        dp[i][j] = 0;  // if not equal then length should starts from 0
                    }
                }
            }
            int ans = Integer.MIN_VALUE;
            for(int i=0; i<n+1; i++){
                for(int j=0; j<m+1; j++){
                    if(dp[i][j]>ans){
                        ans=dp[i][j];
                    }
                }
            }
            return ans;
        }
    }

    //Type 3: https://www.geeksforgeeks.org/printing-longest-common-subsequence/
    class Solution3{
        void printlongestCommonSubsequence(String s1, String s2, int n, int m){
            // code here
            int[][] dp = new int[n+1][m+1];
            for(int i=0; i<dp.length; i++){
                for(int j=0; j<dp[0].length; j++){
                    if(i==0 || j==0){
                        dp[i][j]=0;
                    }
                }
            }

            for(int i=1; i<dp.length; i++){
                for(int j=1; j<m+1; j++){
                    if( s1.charAt(i-1) == s2.charAt(j-1) ){
                        dp[i][j] = dp[i-1][j-1]+1;
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);  // if not equal then length should starts from 0
                    }
                }
            }
            String str = "";
            int idx = dp[m][n];
            int i = n;
            int j= m;
            while(i>0 && j>0){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    str = str + s1.charAt(i-1);
                    i--;
                    j--;

                }else if(dp[i-1][j]>dp[i][j-1]){
                    i--;
                }else{
                    j--;
                }
            }
            System.out.println(str); //It'll print in reverse order
        }
    }
}
