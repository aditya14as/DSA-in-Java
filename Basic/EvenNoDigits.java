package com.aditya.Basic;

import java.awt.*;

public class EvenNoDigits {
    public static void main(String[] args){
        int[] arr = {6,2,1,-1212,12,1,2,45234,12,1241};
        int count = 0;
        for (int num:arr) {

            if(even(num)){
                count++;
            }
        }
        System.out.println(count);
    }
    static boolean even(int num){
        int i=0;
        while(num!=0){
            num=num/10;
            i++;
        }
        if(i%2==0){
            return true;
        }
        else{
            return false;
        }
    }

}
