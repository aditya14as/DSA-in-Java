package com.aditya.HashmapAndHeaps.Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> group = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        list1.add(5);
        list1.add(6);
        list1.add(10);
        list1.add(11);
        list2.add(8);
        list2.add(9);
        list2.add(13);
        list2.add(56);
        list3.add(45);
        list3.add(67);
        list3.add(75);
        list3.add(85);
        group.add(0,list1);
        group.add(1,list2);
        group.add(2,list3);
        System.out.println(mergeKSorted(group));
    }
    public static class Pair implements Comparable<Pair> {
        int li;
        int di;
        int val;
        Pair(int li, int di, int val){
            this.li = li;
            this.di = di;
            this.val = val;
        }

        @Override
        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }
    public static ArrayList<Integer> mergeKSorted(ArrayList<ArrayList<Integer>> lists){
        ArrayList<Integer> rv = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < lists.size(); i++) {
            pq.add(new Pair(i,0,lists.get(i).get(0)));
        }
        while(pq.size()>0){
            Pair p = pq.remove();
            rv.add(p.val);
            p.di++;
            if(p.di<lists.get(p.li).size()){
                p.val = lists.get(p.li).get(p.di);
                pq.add(p);
            }
        }
        return rv;
    }
}
