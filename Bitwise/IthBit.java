package com.aditya.Bitwise;

public class IthBit {
    public static void main(String[] args){
        int num = 422;
        int index = 2;
        System.out.println(findBit(num,index));
    }
    static int findBit(int num,int index){
        int mask = 1<<index-1; // left shift
        int ans = num & mask;  // doing & on 1000 and any no gives 4th bit
        return (ans>>index-1);
    }
}
