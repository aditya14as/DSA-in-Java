package com.aditya.LinkedList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList(){
        this.size =0;
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
        public Node(int value,Node next){
            this.value = value;
            this.next = next;
        }
    }

    public void insertFirst(int value){
        Node n = new Node(value);
        n.next = head;
        head = n;
        if(tail==null){
            tail = head;
        }
        size = size+1;
    }
    public void insertLast(int value){
        if(tail == null){
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size = size +1;
    }
    public void insert(int value, int index){
        if(index==0){
            insertFirst(value);
            return;
        }
        if(index==size){
            insertLast(value);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(value);   // Node node = new Node(value,temp.next)
        node.next = temp.next;         // temp.next = node;
        temp.next = node;
        size++;
    }
    public void deleteFirst(){
        System.out.println();
        System.out.println("1st element was:"+ head.value);
        if(head==tail){
            head=head.next;
            tail = tail.next;
        }
        head = head.next;
        size--;
    }
    public Node getE(int index){
        Node temp = head;
        for(int i=1; i<=index; i++){
            temp = temp.next;
        }
        return temp;
    }
    public int deleteLast(){
        if(head==tail){
            deleteFirst();
        }
        Node temp = getE(size-2);
        int val = tail.value;
        tail = temp;
        temp.next= null;
        return val;
    }
    public int delete(int index){
        if(index==size-1){
            deleteLast();
        }
        if(index==0){
            deleteFirst();
        }
        Node temp = getE(index-1);
        int value = temp.next.value;
        temp.next = temp.next.next;
        return value;
    }
    public int find(int value){
        Node node = head;
        int i =1;
        while(node.next != null){
            if(node.value == value){
                return i;
            }
            node = node.next;
            i++;
        }
        return -1;
    }
    public void display(){
        Node temp = head;
        System.out.print("Head -> ");
        while(temp!=null){
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.print("Tail");
    }
}
