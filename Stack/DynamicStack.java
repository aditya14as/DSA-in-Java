package com.aditya.Stack;

public class DynamicStack extends CustomStack{
    public DynamicStack(){
        super(); // it will call CustomStack()
    }
    public DynamicStack(int size){
        super(size);
    }
    @Override
    public boolean push(int item){
        if(this.isFull()){
            //double the array size
            int[] temp = new int[data.length*2];
            for(int i=0; i<data.length; i++){
                temp[i] = data[i];
            }

            data = temp;
        }
        // Insert item
        return super.push(item);
    }
}
