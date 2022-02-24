package com.aditya.Queue;

public class CircularQueue {
    public int[]data;
    private static final int DEFAULT_SIZE = 10;
    int end = 0;
    int front = 0;
    int size = 0;
    public CircularQueue(){
        this(DEFAULT_SIZE);
    }
    public CircularQueue(int size){
        this.data = new int[size];
    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }
    public boolean isFull(){
        if(size==data.length){
            return true;
        }
        return false;
    }
    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        data[end]= item;
        end++;
        size++;
        end = end% data.length;
        return true;
    }
    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        int removed = data[front];
        front = front+1;
        front = front% data.length;
        size--;
        return removed;
    }
    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        return data[front];
    }
    public void display(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return;
        }
        int i =front;
        do{
            System.out.print(data[i]+" -> ");
            i++;
            i= i%data.length;
        }while(i!=end);
        System.out.println("END");
    }
}
