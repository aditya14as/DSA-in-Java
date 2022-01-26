package com.aditya.Bitwise;

public class FindXOR {
    public static void main(String[] args) {
        int start =3;
        int end =9;
        //for this we find xor from 0 to 9 and then xor from 0 to 2
        int ans = XOR(start-1)^XOR(9);
        System.out.println(ans);
        
        // for verification, will give TLE for large no
        int ans2 =0;
        for (int i = start; i <=end ; i++) {
            ans2 = ans2^i;
        }
        System.out.println(ans2);
    }
    // to find xor from 0 to n
    private static int XOR(int n) {
        if(n%4==0){
            return n;
        }
        if(n%4==1){
            return 1;
        }
        if(n%4==2){
            return n+1;
        }
        return 0;
    }
}
