package com.aditya.HashmapAndHeaps;
import java.util.*;

public class HeapComparatorAndComparable {
    public static class PriorityQueue<T> {
        ArrayList data;
        Comparator comp;

        public PriorityQueue() {
            data = new ArrayList < >();
            comp = null;
        }

        public PriorityQueue(Comparator comp) {
            data = new ArrayList <>();
            this.comp = comp;
        }

        private boolean isSmaller(int i, int j)
        {
            if (comp == null) {
                Comparable ith = (Comparable) data.get(i);
                Comparable jth = (Comparable) data.get(j);
                if (ith.compareTo(jth) < 0)
                {
                    return true;
                }
                else {
                    return false;
                }
            }
            else
            {
                T ith = (T) data.get(i);
                T jth = (T) data.get(j);

                if(comp.compare(ith, jth) < 0){
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }

        public void add(T val) {
            data.add(val);
            upheapify(data.size() - 1);
        }

        private void upheapify(int i) {
            if (i == 0) {
                return;
            }

            int pi = (i - 1) / 2;
            if (isSmaller(i, pi) == true) {
                swap(i, pi);
                upheapify(pi);
            }
        }

        private void swap(int i, int j) {
            T ith = (T) data.get(i);
            T jth = (T) data.get(j);
            data.set(i, jth);
            data.set(j, ith);
        }

        public T remove() {
            if (this.size() == 0) {
                System.out.println(" Underflow " );
                return null;
            }
            swap(0, data.size() - 1);
            T val = (T) data.remove(data.size() - 1);
            downheapify(0);
            return val;
        }

        private void downheapify(int i) {
            int mini = i;

            int li = 2 * i + 1;
            if (li < data.size() && isSmaller(li, mini) == true) {
                mini = li;
            }

            int ri = 2 * i + 2;
            if (ri < data.size() && isSmaller(ri, mini) == true) {
                mini = ri;
            }

            if (mini != i ) {
                swap(i, mini);
                downheapify(mini);
            }
        }

        public T peek() {
            if (this.size() == 0 )
            {
                System.out.println( " Underflow " );
                return null;
            }

            return (T) data.get(0);
        }

        public int size() {
            return data.size();
        }
    }
    static class Student implements Comparable< Student> {
        int rno;
        int ht;
        int weight;

        Student(int rno, int ht, int weight)
        {
            this.rno = rno;
            this.ht = ht;
            this.weight = weight;
        }

        public int compareTo(Student o)
        {
            return o.rno - this.rno;
        }

        public String toString()
        {
            return "rno= " + rno + " height= " + ht + " weight= " + weight;
        }
    }

    static class StudentHtComparator implements Comparator< Student> {
        public int compare(Student s1, Student s2)
        {
            return s1.ht - s2.ht;
        }
    }

    static class StudentWtComparator implements Comparator< Student>
    {
        public int compare(Student s1, Student s2)
        {
            return s1.weight - s2.weight;
        }
    }

    public static void main(String[] args)
    {
        PriorityQueue< Student> pq = new PriorityQueue<>(new StudentWtComparator());

        pq.add(new Student(1, 180, 82));
        pq.add(new Student(2, 170, 81));
        pq.add(new Student(3, 200, 85));
        pq.add(new Student(4, 190, 87));
        pq.add(new Student(5, 185, 70));

        while (pq.size() != 0)
        {
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
