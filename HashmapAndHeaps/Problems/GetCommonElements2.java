package com.aditya.HashmapAndHeaps.Problems;

import java.util.HashMap;

public class GetCommonElements2 {
    public static void main(String[] args) {
        int[] arr1 = {4,3,2,3,3,2,1,3};
        int[] arr2 = {5,7,4,2,3,3,5,6,7,7};
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            if(map.containsKey(arr1[i])){
                int of = map.get(arr1[i]);
                of = of+1;
                map.put(arr1[i],of);
            }else{
                map.put(arr1[i],1);
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            if(map.containsKey(arr2[i])){
                System.out.println(arr2[i]);
                int f = map.get(arr2[i]);
                f=f-1;
                map.put(arr2[i],f);
            }
        }
    }
}
