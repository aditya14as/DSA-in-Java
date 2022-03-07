package com.aditya.GenericTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Trees {
    private static class Node{
        int data;
        ArrayList<Node> child = new ArrayList<>();
        public Node(int data){
            this.data = data;
        }
    }
    private static class Pair{
        Node node;
        int level;
        public Pair(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,200,-1,-1,-1};
        Stack<Node> st = new Stack<>();
        Node root=null;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==-1){
                st.pop();
            }else{
                Node node = new Node(arr[i]);
                if(st.size()>0){
                    st.peek().child.add(node);
                }else{
                    root = node;
                }
                st.push(node);
            }
        }
        display(root);
//        System.out.println(sizeofTree(root));
//        System.out.println(max(root));
//        System.out.println(height(root));
//        traversal(root);
//        levelOrderTraversal(root);
//        levelOrderLineWise3(root);
//        removeLeaves(root);
//        levelOrderLineWise3(root);
//        levelOrderLinewiseZigZag(root);
//        System.out.println();
//        linearize2(root);
//        System.out.println();
//        levelOrderTraversal(root);
//        System.out.println(isAvailable(root,12));
//        System.out.println(nodeToRootPath(root,100));
//        System.out.println(lowestCommonAncestor(root,110,70));
//        System.out.println(distanceBWnodes(root,90,20));
        System.out.println(isSymmetric(root));
    }

    public static void display(Node node){
        System.out.print(node.data + "->");
        for (int i = 0; i < node.child.size(); i++) {
            System.out.print(node.child.get(i).data+",");
        }
        System.out.println();
        for (int i = 0; i < node.child.size(); i++) {
            display(node.child.get(i));
        }
    }
    public static int sizeofTree(Node node){
        if (node.child.size()==0){
            return 1;
        }
        int sum = 0;
        for (int i = 0; i < node.child.size(); i++) {
            sum = sum + sizeofTree(node.child.get(i));
        }
        return sum+1;
    }
    public static int max(Node node){
        int maxN = Integer.MIN_VALUE;
        for (int i = 0; i < node.child.size(); i++) {
            int n = max(node.child.get(i));
            maxN = Math.max(maxN,n);
        }
        if(maxN< node.data){
            maxN = node.data;
        }
        return maxN;
    }
    public static int height(Node node){
        int h = -1; //Height is the longest distance from root to the leaf node
        for (int i = 0; i < node.child.size(); i++) {
            int x = height(node.child.get(i));
            h = Math.max(h,x);
        }
        return h+1;
    }
    public static void traversal(Node node){
        System.out.println("Node pre->"+node.data);
        for (int i = 0; i < node.child.size(); i++) {
            System.out.println("Edge pre->"+node.child.get(i).data);
            traversal(node.child.get(i));
            System.out.println("Edge post->"+node.child.get(i).data);
        }
        System.out.println("Node post->"+node.data);
    }
    public static void levelOrderTraversal(Node node){
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        while(!q.isEmpty()){
            node = q.remove();
            System.out.print(node.data+" ");
            for (int i = 0; i < node.child.size(); i++) {
                q.add(node.child.get(i));
            }
        }
        System.out.println();
    }
    public static void levelOrderLineWise(Node node){
        Queue<Node> p = new ArrayDeque<>();
        Queue<Node> c = new ArrayDeque<>();
        p.add(node);
        while(!p.isEmpty() || !c.isEmpty()){
            node = p.remove();
            System.out.print(node.data+" ");
            for (int i = 0; i < node.child.size(); i++) {
                c.add(node.child.get(i));
            }
            if(p.isEmpty()){
                p=c;
                c= new ArrayDeque<>();
                System.out.println();
            }
        }
    }
    public static void levelOrderLinewiseZigZag(Node node){
        Stack<Node> p = new Stack<>();
        Stack<Node> c = new Stack<>();
        int count = 1;
        p.add(node);
        while(!p.isEmpty()){
            node = p.pop();
            System.out.print(node.data+" ");
            if(count%2==1){
                for (int i = 0; i < node.child.size(); i++) {
                    c.push(node.child.get(i));
                }
            }else{
                for(int i= node.child.size()-1; i>=0; i--){
                    c.push(node.child.get(i));
                }
            }
            if(p.isEmpty()){
                System.out.println();
                p = c;
                c = new Stack<>();
                count++;
            }
        }
    }
    public static void levelOrderLineWise2(Node node){
        Queue<Node> p = new ArrayDeque<>();
        p.add(node);
        p.add(new Node(-1));
        while(!p.isEmpty()){
            node = p.remove();
            if(node.data!= -1){
                System.out.print(node.data+" ");
                for (int i = 0; i < node.child.size(); i++) {
                    p.add(node.child.get(i));
                }
            }else{
                if(p.size()>0){
                    System.out.println();
                    p.add(new Node(-1));
                }
            }
        }
    }
    public static void levelOrderLineWise3(Node node){
        Queue<Pair> p = new ArrayDeque<>();
        int level = 1;
        p.add(new Pair(node,level));
        while(!p.isEmpty()){
            Pair pa = p.remove();
            if(pa.level>level){
                level = pa.level;
                System.out.println();
            }
            System.out.print(pa.node.data+" ");
            for (int i = 0; i < pa.node.child.size(); i++) {
                p.add(new Pair(pa.node.child.get(i),level+1));
            }
        }
    }
    public static void removeLeaves(Node node){
        for (int i = node.child.size()-1; i >=0; i--) {
            Node c = node.child.get(i);
            if(c.child.size()==0){
                node.child.remove(c);
            }
        }
        for (int i = 0; i < node.child.size(); i++) {
            removeLeaves(node.child.get(i));
        }
    }
    public static void linearize(Node node){
        for (int i = 0; i < node.child.size(); i++) {
            linearize(node.child.get(i));
        }
        while(node.child.size()>1){
            Node last = node.child.remove(node.child.size()-1);
            Node slast = node.child.get(node.child.size()-1);
            Node slastTail = getTail(slast);
            slastTail.child.add(last);
        }
    }
    public static Node getTail(Node node){
        while(node.child.size()!=0){
            node = node.child.get(0);
        }
        return node;
    }
    public static Node linearize2(Node node){
        if(node.child.size()==0){
            return node;
        }
        Node lastTail = linearize2(node.child.get(node.child.size()-1));
        while(node.child.size()>1){
            Node last = node.child.remove(node.child.size()-1);
            Node sl = node.child.get(node.child.size()-1);
            Node tailOfSl = linearize2(sl);
            tailOfSl.child.add(last);
        }
        return lastTail;
    }
    public static boolean isAvailable(Node node, int target){
        if(node.data== target){
            return true;
        }
        for(int i = 0; i<node.child.size(); i++){
            if(isAvailable(node.child.get(i),target)){
                return true;
            }
        }
        return false;
    }
    public static ArrayList<Integer> nodeToRootPath(Node node,int target){
        if(node.data==target){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }
        for (int i = 0; i < node.child.size(); i++) {
            ArrayList<Integer> list2 = nodeToRootPath(node.child.get(i),target);
            if(list2.size()>0){
                list2.add(node.data);
                return list2;
            }
        }
        return new ArrayList<>();
    }
    public static int lowestCommonAncestor(Node root, int a,int b){
        ArrayList<Integer> list1 = nodeToRootPath(root,a);
        ArrayList<Integer> list2 = nodeToRootPath(root,b);
        int i = list1.size()-1;
        int j = list2.size()-1;
        while(i>=0 && j>=0 && list1.get(i)==list2.get(j)){
            i--;
            j--;
        }
        return list2.get(j+1);
    }
    public static int distanceBWnodes(Node root,int a,int b){
        ArrayList<Integer> list1 = nodeToRootPath(root,a);
        ArrayList<Integer> list2 = nodeToRootPath(root,b);
        int i = list1.size()-1;
        int j = list2.size()-1;
        while(i>=0 && j>=0 && list1.get(i)==list2.get(j)){
            i--;
            j--;
        }
        return i+j+2;
    }
    public static boolean isSimilar(Node a, Node b){
        if(a.child.size()!=b.child.size()){
            return false;
        }
        for(int i=0; i<a.child.size(); i++){
            Node ac = a.child.get(i);
            Node bc = a.child.get(i);
            if(!isSimilar(ac,bc)){
                return false;
            }
        }
        return true;
    }
    public static boolean isMirror(Node a , Node b){
        if(a.child.size()!=b.child.size()){
            return false;
        }
        for (int i = 0; i < a.child.size(); i++) {
            Node ac = a.child.get(i);
            Node bc = b.child.get(b.child.size()-1-i);
            if(!isMirror(ac,bc)){
                return false;
            }
        }
        return true;
    }
    public static boolean isSymmetric(Node root){
        for (int i = 0; i < root.child.size()/2; i++) {
            Node a = root.child.get(i);
            Node b = root.child.get(root.child.size()-1-i);
            if(!symmetricHelper(a,b)){
                return false;
            }
        }
        return true;
    }
    public static boolean symmetricHelper(Node a, Node b){
        if(a.child.size()!=b.child.size()){
            return false;
        }
        for (int i = 0; i <a.child.size() ; i++) {
            Node ac = a.child.get(i);
            Node bc = b.child.get(b.child.size()-1-i);
            if(!symmetricHelper(ac,bc)){
                return false;
            }
        }
        return true;
    }
}
