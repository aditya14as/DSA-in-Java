package com.aditya.Bitwise;

public class ResetIthBit {
    public static void main(String[] args){
        int num = 422;
        int index = 2;
        System.out.println(reset(num,index));
    }
    static int reset(int num,int index){
        int mask = 1<<index-1; // left shift
        mask = ~mask; // complement of 1000 = 0111
        int ans = num & mask;  // doing | on 0111 and any no reset 4th bit
        return ans;
    }
}
