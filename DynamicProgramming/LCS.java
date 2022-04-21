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

    //Type 4: https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1/#
    class Solution4
    {  //LCS(Type-1) will return common character if we add both the string then its common character will
        // appear two times so we substract lcs
        //Function to find length of shortest common supersequence of two strings.
        public static int shortestCommonSupersequence(String x,String y,int m,int n)
        {
            //Your code here
            int[][] dp = new int[m+1][n+1];
            for(int i=0; i<dp.length; i++){
                for(int j=0; j<dp[0].length; j++){
                    if(i==0 || j==0){
                        dp[i][j]=0;
                    }
                }
            }

            for(int i=1; i<m+1; i++){
                for(int j=1; j<n+1; j++){
                    if(x.charAt(i-1)==y.charAt(j-1)){
                        dp[i][j] = 1+dp[i-1][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i][j-1] , dp[i-1][j]);
                    }
                }
            }

            return x.length()+y.length() - dp[m][n];  // Substract LCS after adding to both the strings
        }
    }

    //Type 5: https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1/#
    class Solution5
        //LCS will return common subsequence

    {
        public int minOperations(String x, String y)
        {
            // Your code goes here
            int m = x.length();
            int n = y.length();
            int[][] dp = new int[m+1][n+1];
            for(int i=0; i<dp.length; i++){
                for(int j=0; j<dp[0].length; j++){
                    if(i==0 || j==0){
                        dp[i][j]=0;
                    }
                }
            }

            for(int i=1; i<m+1; i++){
                for(int j=1; j<n+1; j++){
                    if(x.charAt(i-1)==y.charAt(j-1)){
                        dp[i][j] = 1+dp[i-1][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i][j-1] , dp[i-1][j]);
                    }
                }
            }

            int del = m-dp[m][n]; // Delete will be m-lcs
            int ins = n-dp[m][n]; // insert will be n-lcs
            return del+ins; // total will be answer
        }
    }

    //Type 6: https://practice.geeksforgeeks.org/problems/longest-palindromic-subsequence-1612327878/1/
    //Here it's given only one string
    //Hint: LCS of x and reverse of x will be longest palindrome subsequence
    class Solution
    {
        public int longestPalinSubseq(String x)
        {
            //code here
            String y="";
            for(int i=x.length()-1; i>=0; i--){
                y=y+x.charAt(i);
            }
            int m = x.length();
            int n = y.length();
            int[][] dp = new int[m+1][n+1];
            for(int i=0; i<dp.length; i++){
                for(int j=0; j<dp[0].length; j++){
                    if(i==0 || j==0){
                        dp[i][j]=0;
                    }
                }
            }

            for(int i=1; i<m+1; i++){
                for(int j=1; j<n+1; j++){
                    if(x.charAt(i-1)==y.charAt(j-1)){
                        dp[i][j] = 1+dp[i-1][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i][j-1] , dp[i-1][j]);
                    }
                }
            }

            return dp[m][n];
        }
    }

    //Type 7: https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions4610/1/
    class Solution7
    {
        int minDeletions(String x, int m)
        {
            // code here

            String y="";
            for(int i=x.length()-1; i>=0; i--){
                y=y+x.charAt(i);
            }
            // int m = x.length();
            int n = y.length();
            int[][] dp = new int[m+1][n+1];
            for(int i=0; i<dp.length; i++){
                for(int j=0; j<dp[0].length; j++){
                    if(i==0 || j==0){
                        dp[i][j]=0;
                    }
                }
            }

            for(int i=1; i<m+1; i++){
                for(int j=1; j<n+1; j++){
                    if(x.charAt(i-1)==y.charAt(j-1)){
                        dp[i][j] = 1+dp[i-1][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i][j-1] , dp[i-1][j]);
                    }
                }
            }

            return m-dp[m][n]; //Difference between LCS of string x and reverse of string x will be minimum deletion
        }
    }

    //Type 8: https://practice.geeksforgeeks.org/problems/form-a-palindrome1455/1/#
    //Find the longest palindrome subsequence as in T-6
    //Lps always equal to or less that length of string x
    //The difference between length and lps will be answered
    //Because the difference is the minimum character which lacks to make it palindrome
    //And that will be minimum addition
    class Solution8{
        static int countMin(String x)
        {
            // code here
            String y="";
            for(int i=x.length()-1; i>=0; i--){
                y=y+x.charAt(i);
            }
            int m = x.length();
            int n = y.length();
            int[][] dp = new int[m+1][n+1];
            for(int i=0; i<dp.length; i++){
                for(int j=0; j<dp[0].length; j++){
                    if(i==0 || j==0){
                        dp[i][j]=0;
                    }
                }
            }

            for(int i=1; i<m+1; i++){
                for(int j=1; j<n+1; j++){
                    if(x.charAt(i-1)==y.charAt(j-1)){
                        dp[i][j] = 1+dp[i-1][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i][j-1] , dp[i-1][j]);
                    }
                }
            }

            return m-dp[m][n];

        }
    }
    //Type 9: https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1#
    class Solution9
    {
        public int LongestRepeatingSubsequence(String x)
        {
            // code here
            String y=x;

            int m = x.length();
            int n = y.length();
            int[][] dp = new int[m+1][n+1];
            for(int i=0; i<dp.length; i++){
                for(int j=0; j<dp[0].length; j++){
                    if(i==0 || j==0){
                        dp[i][j]=0;
                    }
                }
            }

            for(int i=1; i<m+1; i++){
                for(int j=1; j<n+1; j++){
                    if(x.charAt(i-1)==y.charAt(j-1) && i!=j){   //Only difference is the consider that character which is equal and
                        //not on the same i and j because character with same i and j will eventually make it to the LCS
                        dp[i][j] = 1+dp[i-1][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i][j-1] , dp[i-1][j]);
                    }
                }
            }
            return dp[m][n];
        }
    }

    //Type 10: https://www.geeksforgeeks.org/print-shortest-common-supersequence/
    // Printing the Type-4
    class Solution10{
        void printShortestCommonSuperSequence(String s1, String s2, int n, int m){
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
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); 
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
                    str = str+ s1.charAt(i-1); // Also printing those character which are not common
                    i--;
                }else{
                    str = str + s2.charAt(j-1); //  Also printing those character which are not common
                    j--;
                }
            }
            //Is it possible that above while loop will break even if one of the i and j is greater than 0
            // to add those left out character we run loop for i and j again
            // Execute only one of the loop
            while(i>0){
                str = str+ s1.charAt(i-1);
                i--;
            }
            while(j>0){
                str = str+ s1.charAt(j-1);
                j--;
            }
            System.out.println(str); //It'll print in reverse order
        }
    }

    //Type 11: https://leetcode.com/problems/number-of-matching-subsequences/
    // Give TLE on normal iterations on leetcode
    // Will give TLE with DP as well


    //Method-1 Normal iterations
    class Solution11a {
        public int numMatchingSubseq(String s, String[] words) {
            int count=0;
            for(int i=0; i<words.length; i++){
                if(solver(s,words[i])){
                    count++;
                }
            }
            return count;
        }
        public boolean solver(String x, String y){
            int n = x.length();
            int m = y.length();
            int i=n;
            int j=m;
            while(i>0 && j>0){
                if(x.charAt(i-1)==y.charAt(j-1)){
                    i--;
                    j--;
                }else{
                    i--;
                }
            }
            if(j==0){
                return true;
            }else{
                return false;
            }

        }
    }

    //Method 2: DP approach
    class Solution11b

    {
        public boolean numMatchingSubseq(String x, String y)
        {
            // Your code goes here
            //String x is parent and string y is child
            int m = x.length();
            int n = y.length();
            int[][] dp = new int[m+1][n+1];
            for(int i=0; i<dp.length; i++){
                for(int j=0; j<dp[0].length; j++){
                    if(i==0 || j==0){
                        dp[i][j]=0;
                    }
                }
            }

            for(int i=1; i<m+1; i++){
                for(int j=1; j<n+1; j++){
                    if(x.charAt(i-1)==y.charAt(j-1)){
                        dp[i][j] = 1+dp[i-1][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i][j-1] , dp[i-1][j]);
                    }
                }
            }
           if(n==dp[m][n]){ //If lcs is equal to length of child string then child string is present in parent string
               return true;
           }else{
               return false;
           }
        }
    }
}
