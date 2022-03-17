package com.aditya.HashmapAndHeaps.Problems;

import java.util.PriorityQueue;

public class KSortedArray {
    public static void main(String[] args) {
        int[] arr = {2,3,1,4,5,6,7,5,8,9};
        int k = 2;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i <=k ; i++) {
            pq.add(arr[i]);
        }
        for (int i = k+1; i<arr.length; i++){
            System.out.println(pq.remove());
            pq.add(arr[i]);
        }
        while(pq.size()>0){
            System.out.println(pq.remove());
        }
    }
}
