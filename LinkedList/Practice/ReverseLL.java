package com.aditya.LinkedList.Practice;

public class ReverseLL {
    Node head;
    Node tail;
    private int size;

    public class Node{
        private int value;
        private Node next;
        public Node(int value){
            this.value = value;
        }
    }
    public ReverseLL(){
        this.head = null;
        this.size = 0;
    }
    //Display Linked List using linked list
    public void display(){
        Node temp = head;
        System.out.print("Head -> ");
        while(temp!=null){
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.print("Tail");
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
    public Node get(int index){
        Node temp = head;
        for(int i=1; i<=index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public void reverseRec(Node node){
        if( node == tail){
            head = tail;
            return;
        }
        reverseRec(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }
    public void inplaceReverse(){
        if(size<2){
            return;
        }
        Node prev = null;
        Node current = head;
        Node after = head.next;
        while(current!=null){
            current.next = prev;
            prev = current;
            current = after;
            if(after!=null){
                after = after.next;
            }
            head=prev;
        }


    }
    public Node reverseBetween(int left, int right) {
        if(left==right){
            return head;
        }
        Node prev = null;
        Node current = head;
        Node after = head.next;
        //Traverse until current reaches to left
        for(int i=0 ; i<left-1 && current != null; i++){
            prev = current;
            current = current.next;
            if(after!=null){
                after = after.next;
            }
        }

        Node last = prev; //prev node will eventually turned out to be last so we have to store it somewhere
        Node newE = current;
        for(int i=0 ;  i<right-left+1 && current!=null; i++){
            current.next = prev;
            prev = current;
            current = after;
            if(after!=null){
                after = after.next;
            }
        }
        if(last!=null){
            last.next = prev;
        }else{
            head = prev;
        }
        newE.next = current;
        return head;
    }
    public static void main(String[] args){
        ReverseLL list = new ReverseLL();
        for (int i = 7; i > 0; i--) {
            list.insertLast(i*2);
        }
        list.display();
        list.reverseBetween(2,4);
        System.out.println();
        list.display();
    }

}
