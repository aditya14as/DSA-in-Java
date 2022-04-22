package com.aditya.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MCM {
    //Type 1: https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1/#
    //Revise again
    //S-1: Find i and j
    //S-2: Find right base condition
    //S-3: Find k loop scheme. Here k is used for partitioning
    //S-4: Operate for left recursion call and right recursion call a/c to question and update ans

    class Solution{
        static int matrixMultiplication(int n, int arr[])
        {
            // code here
            int[][] dp = new int[n+1][n+1];
            for(int i =0; i<dp.length; i++){
                Arrays.fill(dp[i], -1);
            }
            return helper(arr,1,n-1,dp);
        }
        // i starts from 1 because a1 = arr[i]*arr[i-1] gives negative index for 0 as k is starting from i and we need to
        // multiply k-1
        static int helper(int[] arr, int i,int j,int[][] dp){
            if(i==j) return 0;
            int ans = Integer.MAX_VALUE;
            if(dp[i][j] != -1){
                return dp[i][j];
            }
            // we can also use for(int k=i+1; k<=j; k++)
            for(int k=i; k<j; k++){
                int temp = helper(arr,i,k,dp)+arr[i-1]*arr[k]*arr[j]+helper(arr,k+1,j,dp);
                if(temp<ans){
                    ans = temp;
                }
            }
            return dp[i][j] = ans;
        }
    }

    //Type-2: https://practice.geeksforgeeks.org/problems/palindromic-patitioning4845/1/#
    class Solution2{
        static int palindromicPartition(String str)
        {
            // code here
            int n = str.length();
            int[][] dp = new int[n+1][n+1];
            for(int i =0; i<dp.length; i++){
                Arrays.fill(dp[i], -1);
            }
            return helper(str,0,str.length()-1,dp);
        }

        static int helper(String s,int i, int j,int[][] dp){
            if(i>=j){
                return 0;
            }
            if(dp[i][j] != -1){
                return dp[i][j];
            }
            if(isPal(s,i,j)){
                return 0;
            }

            int ans = Integer.MAX_VALUE;
            for(int k=i; k<j; k++){
                // int temp = helper(s,i,k,dp) + 1 + helper(s,k+1,j,dp); //Perfectly okay but give TLE on interview bit
                // Addition of 1 to left and right recursion call is because we are partitioning 1 using k
                // Here i starts from 0 because there is no operations where i-1 is performed
                int left;
                if(dp[i][k] != -1){
                    left = dp[i][k];
                }else{
                    dp[i][k] = helper(s,i,k,dp);
                    left = dp[i][k];
                }
                int right;
                if(dp[k+1][j] != -1){
                    right = dp[k+1][j];
                }else{
                    dp[k+1][j] = helper(s,k+1,j,dp);
                    right = dp[k+1][j];
                }

                int temp = left+right+1;
                ans = Math.min(temp,ans);


                //Alternatively for Leetcode
//                since traditional mcm approach is giving tle we need to optimize it. so for that we can observe is that for two calls i,k and k+1,j .
//                we can check if i,k partition is palindrome then only call k+1,j. why? bcoz we want palindrome
//                parititon in answer so if first half is not palindrome. don't call right half.
//                rest code is quite similar to Matrix chain multiplication
//                if (isPal(s, i, k)) {
//                    int ans2 = 1 + helper(s, k + 1, j, dp);
//                    ans = Math.min(ans, ans2);
//                    dp[i][j] = ans;
//                    }
//                }
//                return ans;
            }
            return dp[i][j] = ans;


        }

        static boolean isPal(String s,int i, int j){
            if(i==j){
                return true;
            }
            while(j>i){
                if(s.charAt(i)!=s.charAt(j)){
                    return false;

                }
                i++;
                j--;
            }
            return true;
        }
    }

    //Type 3: https://practice.geeksforgeeks.org/problems/boolean-parenthesization5610/1/#
    //Revise again
    class Solution3{
        static HashMap<String, Integer> map;
        static int countWays(int n, String s){
            // code here
            map = new HashMap<String, Integer>();
            return helper(s,0,n-1,true)%1003;
        }

        static int helper(String s, int i, int j,boolean isTrue){
            String temp = new String(i+"_"+j+"_"+isTrue);
            if(map.containsKey(temp)){
                return map.get(temp);
            }
            if(i>j){
                map.put(temp,0);
                return 0;
            }

            if(i==j){
                char sign = s.charAt(i);
                if(isTrue && sign == 'T'){
                    map.put(temp,1);
                    return 1;
                }
                if(!isTrue && sign == 'F'){
                    map.put(temp,1);
                    return 1;
                }

                map.put(temp,0);
                return 0;
            }

            int ans =0;
            for(int k=i+1; k<j; k+=2){
                int lf , lt, rf, rt;
                String l1 = new String(i + "_" + (k-1) + "_true");
                String l2 = new String(i + "_" + (k-1) + "_false");
                String r1 = new String( (k+1) + "_"+j + "_true" );
                String r2 = new String( (k+1) + "_"+j + "_false" );

                if(map.containsKey(l1)) {
                    lt = map.get(l1);
                }else{
                    lt = helper(s,i,k-1,true) % 1003;
                    map.put(l1,lt);
                }

                if(map.containsKey(l2)) {
                    lf = map.get(l2);
                }else{
                    lf = helper(s,i,k-1,false) % 1003;
                    map.put(l2,lf);
                }

                if(map.containsKey(r1)) {
                    rt = map.get(r1);
                }else{
                    rt = helper(s,k+1,j,true) % 1003;
                    map.put(r1,rt);
                }

                if(map.containsKey(r2)) {
                    rf = map.get(r2);
                }else{
                    rf = helper(s,k+1,j,false) % 1003;
                    map.put(r2,rf);
                }

                char op = s.charAt(k);
                if(op == '&'){
                    if(isTrue){
                        ans = ans + (lt * rt);
                    }else{
                        ans = ans + (lf*rt + lt*rf + lf*rf);
                    }
                }

                if(op == '|'){
                    if(isTrue){
                        ans = ans + (lt*rt + lt*rf + lf*rt);
                    }else{
                        ans = ans + (lf * rf);
                    }
                }

                if(op == '^'){
                    if(isTrue){
                        ans = ans + (lf*rt + lt*rf);
                    }else{
                        ans = ans + (rt*lt + lf*rf);
                    }
                }
            }

            map.put(temp,ans%1003);
            return ans;
        }
    }

    //Type 4: https://leetcode.com/problems/scramble-string/
    class Solution4 {
        public Map<String, Boolean> mp = new HashMap<>();
        public boolean isScramble(String s1, String s2) {
            if(s1.length() != s2.length()){
                return false;
            }
            if(s1.equals(s2) == true){
                return true;
            }

            if(s1.isEmpty() == true){
                return true;
            }

            return helper(s1,s2);
        }
        public boolean helper(String a, String b){
            if(a.length() != b.length()){
                return false;
            }
            if(a.equals(b)==true){
                return true;
            }

            if(a.length()<=1){
                return false;
            }

            int n = a.length();
            boolean flag = false;
            String key = a + "_" + b;
            if(mp.containsKey(key)){
                return mp.get(key);
            }

            for(int i=1; i<n; i++){ //I is used as partitioning of string
                boolean unswap = helper(a.substring(0,i), b.substring(0,i) ) && helper(a.substring(i), b.substring(i));
                boolean swap = helper(a.substring(0,i),b.substring(n-i)) && helper(a.substring(i),b.substring(0,n-i));
                if(swap || unswap){
                    flag = true;
                    break;
                }
            }
            mp.put(key,flag);
            return flag;
        }
    }

    //Type 5: https://leetcode.com/problems/super-egg-drop/

    //This method is linear succefully submitted to gfg but gives TLE to leetcode
    class Solution5a
    {
        //Function to find minimum number of attempts needed in
        //order to find the critical floor.
        static int eggDrop(int n, int k)
        {
            // Your code here
            int[][] dp = new int[n+1][k+1];
            for(int i =0; i<dp.length; i++){
                Arrays.fill(dp[i], -1);
            }
            return solve(n,k,dp);

        }

        static int solve(int e, int f, int[][] dp){
            if(f==0 || f==1){
                return f;
            }
            if(e==1){
                return f;
            }
            if(dp[e][f] != -1){
                return dp[e][f];
            }
            int ans = Integer.MAX_VALUE;
            for(int k = 1; k<=f; k++){
                int temp = 1 + Math.max(solve(e-1,k-1,dp),solve(e,f-k,dp));
                ans = Math.min(ans,temp);
            }

            return dp[e][f] = ans;
        }
    }

    //This method is Binary search succefully submitted to leetcode
    class Solution5b {
        Integer dp[][]=new Integer[101][10001];
        //Declared wrapper class because no need to initialise values, will be null default

        public int superEggDrop(int K, int N) {

            if(K==1)//when there is only one egg
                return N;

            if(N==0 || N==1)//when no. of floors are 0 or 1
                return N;

            if(dp[K][N]!=null)//checking if it is filled
                return dp[K][N];

            int l=1,h=N;
            int ans=Integer.MAX_VALUE;

            while(l<=h)
            {
                int mid=(l+h)/2;

                int down_temp=superEggDrop(K-1,mid-1);//If egg breaks go down

                int up_temp=superEggDrop(K,N-mid);//if egg doesn't break go up

                int temp=1+Math.max(down_temp,up_temp);
                //adding one because we have used 1 attempt and max of up and down because
                //we need worst case attempts from both

                if(down_temp<up_temp)//if down attempts are less we only require upper ones and vise versa
                    l=mid+1;
                else
                    h=mid-1;

                ans=Math.min(temp,ans);//this is beacuse we need minimum of all worst case attempts
            }
            return dp[K][N]=ans;
        }
    }

}
