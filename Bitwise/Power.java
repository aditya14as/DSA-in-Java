package com.aditya.Bitwise;

public class Power {
    public static void main(String[] args) {
        int n = 3;
        int power =6;
        int ans =1;
        while(power>0){
            if((power&1)==1){
                ans = ans*n;
            }
            n=n*n;
            power= power>>1;
        }
        System.out.println(ans);
    }

}

