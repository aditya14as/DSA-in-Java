package com.aditya.HashmapAndHeaps.Problems;


import java.util.HashMap;

public class HighestFrequency {
    public static void main(String[] args) {
        String str = "abracadabara";
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(map.containsKey(ch)){
                int freq = map.get(ch);
                freq = freq+1;
                map.put(ch,freq);
            }else{
                map.put(ch,1);
            }
        }
        char mfc = str.charAt(0);
        for(Character key : map.keySet()){
            if(map.get(key)>map.get(mfc)){
                mfc = key;
            }
        }
        System.out.println(mfc);
    }
}
