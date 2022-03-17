package com.aditya.HashmapAndHeaps.Problems;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianPriorityQueue {
    public static void main(String[] args) {
        MedianPQ pq = new MedianPQ();
        pq.add(12);
        pq.add(8);
        pq.add(109);
        System.out.println(pq.peek());
        pq.add(122);
        pq.add(15);
        pq.add(83);
        pq.add(23);
        System.out.println(pq.peek());
    }
    public static class MedianPQ{
        PriorityQueue< Integer> left;
        PriorityQueue< Integer> right;

        public MedianPQ() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        public void add(int val) {
            if (right.size() > 0 && val > right.peek()) {
                right.add(val);
            } else {
                left.add(val);
            }

            handleBalance();
        }

        private void handleBalance() {
            if (left.size() - right.size() == 2) {
                right.add(left.remove());
            } else if (right.size() - left.size() == 2) {
                left.add(right.remove());
            }
        }

        public int remove() {
            if (this.size() == 0) {
                System.out.println("Underflow");
                return -1;
            } else if (left.size() >= right.size()) {
                return left.remove();
            } else {
                return right.remove();
            }
        }

        public int peek() {
            if (this.size() == 0) {
                System.out.println("Underflow");
                return -1;
            } else if (left.size() >= right.size()) {
                return left.peek();
            } else {
                return right.peek();
            }
        }

        public int size() {
            return left.size() + right.size();
        }
    }
}
