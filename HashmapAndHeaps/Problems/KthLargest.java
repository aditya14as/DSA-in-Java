package com.aditya.HashmapAndHeaps.Problems;

import java.util.PriorityQueue;

public class KthLargest {
    public static void main(String[] args) {
        int[] arr = {2,10,5,17,7,18,6,4};
        int k = 3;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            if(i<k){
                pq.add(arr[i]);
            }else{
                if(pq.peek()<arr[i]){
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }
        while (pq.size()>0){
            System.out.println(pq.remove());
        }
    }

}
