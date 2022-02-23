package com.aditya.LinkedList.Practice;

import com.aditya.LinkedList.LinkedList;

public class LL {
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
    public LL(){
        this.head = null;
        this.size = 0;
    }
    //Display Linked List using linked list
    public void display(){
        LL.Node temp = head;
        System.out.print("Head -> ");
        while(temp!=null){
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.print("Tail");
    }
    //Display Linked list using node
    public static void displayHead(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value+"->");
            temp = temp.next;
        }
    }
    //Insert at first
    public void insertFirst(int value){
        LL.Node n = new Node(value);
        n.next = head;
        head = n;
        if(tail==null){
            tail = head;
        }
        size = size+1;
    }
    //Insertion using Recursion
    public void insertRec(int value,int index){
        head = insertRec(value,index,head);
    }
    public Node insertRec(int value,int index, Node node){
        if(index == 0){
            Node n = new Node(value);
            n.next = node;
            size++;
            return n;
        }
        node.next = insertRec(value,index-1,node.next);
        return node;
    }
    //Insert at last
    public void insertLast(int value){
        if(tail == null){
            insertFirst(value);
            return;
        }
        LL.Node node = new Node(value);
        tail.next = node;
        tail = node;
        size = size +1;
    }
    //Merge two Sorted Linked List
    public static Node mergeTwo(Node list1, Node list2){
        LL list = new LL();
        Node temp = list.head;
        while(list1 != null && list2 != null){
            if(list1.value<list2.value){
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            }else{
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }
        }
        while(list1 != null){
            temp.next = list1;
            temp = temp.next;
            list1 = list1.next;
        }
        while(list2 != null){
            temp.next = list2;
            temp = temp.next;
            list2 = list2.next;
        }
        return list.head.next;
    }
    //Find length of the cycle in a linked list
    public int cycleLength(Node head){
        Node f = head;
        Node s = head;
        while(f!=null && f.next != null){
            f = f.next.next;
            s = s.next;
            if(f==s){
               int count =0;
               Node temp = f;
               do{
                   temp = temp.next;
                   count = count +1;
               }while(temp != f);
               return count;
            }
        }
        return 0;
    }
    //Find the node where cycle starts

    public Node cycleStart(Node head){
       int l = cycleLength(head);
       if(l==0){
           return null;
       }
       Node first = head;
       Node second = head;
       //When first node at l and then start traversing second node then both will meet at start of the cycle
       while(l!=0){
           first = first.next;
           l=l-1;
       }
       while(first!=second){
           first = first.next;
           second = second.next;
       }
       return first;
    }
    public Node sortList(Node head) {
        if(head == null || head.next==null){
            return head;
        }
        Node mid = middle(head);
        Node midNext = mid.next;
        mid.next = null;
        Node left = sortList(head);
        Node right = sortList(midNext);

        return mergeTwo(left,right);

    }
    public Node middle(Node head) {
        Node fast = head;
        Node slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public void bubbleS(){
        bubble(size-1,0);
    }
    public void bubble(int row,int col){
        if(row==1){
            return;
        }
        if(row>col){
            Node first = getE(col);
            Node second = getE(col+1);
            if(first.value>second.value){
                if(first == head){
                    head = second;
                    first.next = second.next;
                    second.next = first;
                }
                else if(second == tail){
                    Node prev = getE(col-1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                }
                else{
                    Node prev = getE(col-1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubble(row,col+1);
        }
        bubble(row-1,0);
    }
    public Node getE(int index){
        Node temp = head;
        for(int i=1; i<=index; i++){
            temp = temp.next;
        }
        return temp;
    }
    public static void main(String[] args) {
//        LL list1 = new LL();
//        list1.insertFirst(9);
//        list1.insertFirst(7);
//        list1.insertFirst(3);
//        LL list2 = new LL();
//        list2.insertFirst(5);
//        list2.insertFirst(3);
//        list2.insertFirst(1);
//        Node node = LL.mergeTwo(list1.head, list2.head);
//        displayHead(node);
        LL list = new LL();
        for (int i = 7; i > 0; i--) {
            list.insertLast(i*2);
        }
        list.display();
        list.bubbleS();
        System.out.println();
        list.display();
    }
}
