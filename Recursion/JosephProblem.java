package com.aditya.Recursion;

public class JosephProblem {
    public static void main(String[] args) {
        int n= 5;
        int k=2;
        System.out.println(find(n-1,k));
    }
    static int find(int n,int k){
        if(n==1){
            return 0;
        }
        int x = find(n-1,k);
        int y = (x+k)%n;
        return y;
    }
}
