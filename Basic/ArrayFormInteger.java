package com.aditya.Basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayFormInteger {
        public static void main(String[] args){
           int[] num = {9,9,9,9,9,9,9,9,9,9};
           int k = 1;
           addToArrayForm(num,k);
        }
        static void addToArrayForm(int[] num, int k) {
            long integer = num[0];
            for(int i=1; i<num.length; i++){
                integer = integer*10;
                integer = integer+num[i];
            }
            integer = integer+k;
            List<Integer> ans = new ArrayList<>();
            int num1 = (int)integer;
            System.out.println(num1);
            while(num1>0){
                ans.add(0,num1%10);
                num1 = num1/10;
            }
            System.out.println(ans);
    }

}
