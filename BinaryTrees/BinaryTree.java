package com.aditya.BinaryTrees;

import java.util.Stack;

public class BinaryTree {
    private static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    private static class Pair{
        Node node;
        int state;
        public Pair(Node node,int state){
            this.node = node;
            this.state = state;
        }
    }
    public static void main(String[] args){
        Integer[] arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};

        Node root = new Node(arr[0],null,null);
        int state = 1;
        Pair rootP = new Pair(root,state);
        Stack<Pair> tree = new Stack<>();
        tree.push(rootP);
        int i=1;
        while(!tree.empty() && i<arr.length){
            Pair top = tree.peek();
            if(top.state==1){
                if(arr[i]!=null){
                    top.node.left = new Node(arr[i],null,null);
                    Pair lp = new Pair(top.node.left,1);
                    tree.push(lp);
                }else{
                    top.node.left = null;
                }
                top.state++;
                i++;
            }
            else if(top.state==2){
                if(arr[i]!=null){
                    top.node.right = new Node(arr[i],null,null);
                    Pair rp = new Pair(top.node.right,1);
                    tree.push(rp);
                }else{
                    top.node.right = null;
                }
                top.state++;
                i++;
            }
            else{
                tree.pop();
            }
        }
        display(root);
        System.out.println(sum(root));
        System.out.println(max(root));
        System.out.println(height(root));
        System.out.println(size(root));
        traversal(root);
    }
    public static void display(Node root){
        if(root==null){
            return;
        }
        String str = "";
        if(root.left == null){
            str = str+ ". <-";
        }
        if (root.left != null){
            str = str+ root.left.data + " <-";
        }
        str = str+root.data;
        if(root.right == null){
            str = str+ "-> .";
        }
        if (root.right != null){
            str = str+"-> "+ root.right.data;
        }
        System.out.println(str);
        display(root.left);
        display(root.right);
    }
    public static int size(Node root){
       if(root==null){
           return 0;
       }
       int l = size(root.left);
       int r = size(root.right);
       return l+r+1;

    }
    public static int max(Node root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        return Math.max(Math.max(max(root.left),max(root.right)),root.data);
    }
    public static int height(Node root){
        if(root==null){
            return -1; //Here height is taking in terms of edge, If height is taking in terms of node then should be 0
        }
        return Math.max(height(root.left),height(root.right))+1;
    }
    public static int sum(Node root){
        if(root==null){
            return 0;
        }
        return sum(root.left)+sum(root.right)+root.data;
    }
    public static void traversal(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.data+"-> In preorder");
        traversal(root.left);
        System.out.println(root.data+"-> In inorder");
        traversal(root.right);
        System.out.println(root.data+"-> In postorder");
    }
}
