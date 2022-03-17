package com.aditya.HashmapAndHeaps.Problems;

import java.util.HashMap;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {10,5,9,1,11,8,6,15,3,12,2};
        HashMap<Integer,Boolean> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],true);
        }
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i]-1)){
                map.put(arr[i],false);
            }
        }
        int msp = 0;
        int ml = 0;
        for (int i = 0; i < arr.length; i++) {
            if(map.get(arr[i])==true){
                int tl = 1;
                int tsp = arr[i];
                while(map.containsKey(tsp+tl)){
                    tl++;
                }
                if(tl>ml){
                    ml = tl;
                    msp = tsp;
                }
            }
        }
        for (int i = 0; i < ml; i++) {
            System.out.println(msp+i);
        }
    }
}
