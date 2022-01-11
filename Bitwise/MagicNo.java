package com.aditya.Bitwise;

public class MagicNo {
    public static void main(String[] args) {
        System.out.println(magic(1));
    }
    static int magic(int n){
        int ans = 0;
        int i=1;
        while(n>0){
            ans = ans+ (n&1)*(int)Math.pow(5,i);
            i++;
            n=n>>1;
        }
        return ans;
    }
}
