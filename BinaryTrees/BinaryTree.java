package com.aditya.BinaryTrees;

import com.aditya.BinarySearchTrees.BST;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
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
//        display(root);
//        System.out.println(sum(root));
//        System.out.println(max(root));
//        System.out.println(height(root));
//        System.out.println(size(root));
//        traversal(root);
//        levelOrderTraversal(root);
//        iterativePrePostInorder(root);
//        System.out.println(nodeToRootPath(root,70));
//        System.out.println(list);
//        printKlevelDown(root,2);
//        pathToLeafFromRoot(root,"",0,0,400);
//        Node n = leftClonedTree(root);
//        display(n);
//        System.out.println();
//        Node t = tBackFromLeftCloned(n);
//        display(t);
//        System.out.println();
        display(root);
//        singleChildNode(root);
//        System.out.println();
//        Node r = removeLeaves(root);
//        display(r);
//        findTilt(root);
//        System.out.println(tilt);
//        isBalanced(root);
//        System.out.println(isBalanced);
//        System.out.println(diameter1(root));
//        DiaPair dia = diameter2(root);
//        System.out.println(dia.dia);
        printKLevelsFar(root,30,1);
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
            return 0; //Here height is taking in terms of node, If height is taking in terms of edge then should be -1
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
    public static void levelOrderTraversal(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node node = q.remove();
                System.out.print(node.data+" ");
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            System.out.println();
        }
    }
    public static void iterativePrePostInorder(Node root){
        Pair p = new Pair(root,1);
        Stack<Pair> st = new Stack<>();
        String pre="";
        String in="";
        String post="";
        st.push(p);
        while(!st.empty()){
            Pair top = st.peek();
            if(top.state==1){
                pre+=top.node.data+" ";
                if(top.node.left != null)
                st.push(new Pair(top.node.left,1));
                top.state++;
            }
            else if (top.state==2){
                in+=top.node.data+" ";
                if(top.node.right!=null)
                st.push(new Pair(top.node.right,1));
                top.state++;
            }
            else{
                post+=top.node.data+" ";
                st.pop();
            }
        }
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);

    }
    static ArrayList<Node> list = new ArrayList<>();
    public static boolean nodeToRootPath(Node root,int target){
        if(root==null){
            return false;
        }
        if(root.data == target){
            list.add(root);
            return true;
        }
        if(nodeToRootPath(root.left,target)){
            list.add(root);
            return true;
        }
        if (nodeToRootPath(root.right,target)){
            list.add((root));
            return true;
        }
        return false;
    }
    public static void printKlevelDown(Node root,int k){
//        if(root==null){
//            return;
//        }
//        Queue<Node> q= new ArrayDeque<>();
//        q.add(root);
//        while(!q.isEmpty() && k>=0){
//            int n = q.size();
//            for (int i = 0; i < n; i++) {
//                Node node = q.remove();
//                if(k==0)System.out.print(node.data + " ");
//                if(node.left!=null){
//                    q.add(node.left);
//                }
//                if (node.right!=null){
//                    q.add(node.right);
//                }
//            }
//            k--;
//        }
        if(root==null || k<0){
            return;
        }
        if (k==0){
            System.out.print(root.data+" ");
        }
        printKlevelDown(root.left,k-1);
        printKlevelDown(root.right,k-1);
    }
    public static void pathToLeafFromRoot(Node root,String path,int sum,int low,int hi){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            sum = sum+root.data;
            if(sum>=low && sum<=hi){
                System.out.println(path+" "+ root.data);
            }
        }
        pathToLeafFromRoot(root.left,path+" "+root.data,sum+root.data,low,hi);
        pathToLeafFromRoot(root.right,path+" "+root.data,sum+root.data,low,hi);

    }
    public static Node leftClonedTree(Node root){
        if(root==null){
            return null;
        }
        Node lcn = leftClonedTree(root.left);
        Node rcn = leftClonedTree(root.right);
        Node node = new Node(root.data,lcn,null);
        root.left = node;
        root.right = rcn;
        return root;
    }
    public static Node tBackFromLeftCloned(Node root){
        if(root==null){
            return null;
        }
        Node lcn = tBackFromLeftCloned(root.left.left);
        Node rcn = tBackFromLeftCloned(root.right);
        root.left = lcn;
        root.right = rcn;
        return root;
    }
    public static void singleChildNode(Node root){
        if(root==null){
            return;
        }
        singleChildNode(root.left);
        singleChildNode(root.right);
        if((root.left == null && root.right!=null) || (root.right == null && root.left != null)){
            System.out.print(root.data+" ");
        }
    }
    public static Node removeLeaves(Node root){
        if(root==null){
            return null;
        }
        if(root.left == null && root.right == null){
            return null;
        }
        root.left = removeLeaves(root.left);
        root.right  = removeLeaves(root.right);
        return root;
    }
    public static int tilt = 0;
    public static int findTilt(Node root){
        if(root==null){
            return 0;
        }
        int ls = findTilt(root.left);
        int rs = findTilt(root.right);
        tilt = tilt + Math.abs(ls-rs);
        return ls+rs+root.data;
    }
    public static boolean isBalanced=true;
    public static int isBalanced(Node root){
        if(root==null){
            return 0;
        }
        int ls = isBalanced(root.left);
        int rs = isBalanced(root.right);
        if(Math.abs(ls-rs)>1){
            isBalanced = false;
        }
        return Math.max(ls,rs) + 1;
    }

    //Time complexity O(n^2)
    public static int diameter1(Node root){
        if(root==null){
            return 0;
        }
        int ld = diameter1(root.left);
        int rd = diameter1(root.right);
        int f = height(root.left) + height(root.right)+2;
        return Math.max(ld,Math.max(rd,f));
    }

    public static class DiaPair{
        int height;
        int dia;
        DiaPair(int height,int dia){
            this.height = height;
            this.dia = dia;
        }
    }
    public static DiaPair diameter2(Node root){
        if(root==null){
            DiaPair dp = new DiaPair(0,0);
            return dp;
        }
        DiaPair lp = diameter2(root.left);
        DiaPair rp = diameter2(root.right);
        int mDia = lp.height+ rp.height +2;
        int mHeight = Math.max(lp.height,rp.height)+1;
        DiaPair mp = new DiaPair(mHeight,mDia);
        return mp;
    }
    public static void printKLevelsFar(Node root,int target,int k){
        list = new ArrayList<>();
        nodeToRootPath(root,target);
        for (int i = 0; i < list.size(); i++) {
            printKlevelDown(list.get(i),k-i,i==0? null : list.get(i-1));
        }

    }
    public static void printKlevelDown(Node root,int k,Node blocker){
        if(root==null || k<0 || root == blocker){
            return;
        }
        if (k==0){
            System.out.print(root.data+" ");
        }
        printKlevelDown(root.left,k-1,blocker);
        printKlevelDown(root.right,k-1,blocker);
    }
    public static class BSTPair{
        int min;
        int max;
        boolean isBST;
        Node largestBSTroot;
        int largestBSTsize;
    }
    // The return value of BSTPair contains minimum value, maximum value, is Binary tree BST or not,root of largest BST
    // size of largest BST(Remember: if whole tree is not BST then these two value will return root and size of BST formed
    // by largest sub tree
    public static BSTPair isBst(Node root){
        if(root==null){
            BSTPair bp = new BSTPair();
            bp.min = Integer.MIN_VALUE;
            bp.max = Integer.MAX_VALUE;
            bp.isBST = true;
            bp.largestBSTroot = null;
            bp.largestBSTsize= 0;
        }
        BSTPair lp = isBst(root.left);
        BSTPair rp = isBst(root.right);
        BSTPair mp = new BSTPair();
        mp.max = Math.max(root.data,Math.max(lp.max,rp.max));
        mp.min = Math.min(root.data,Math.min(lp.min,rp.min));
        mp.isBST = lp.isBST && rp.isBST && (root.data>lp.max && root.data<rp.min);
        if(mp.isBST){
            mp.largestBSTroot = root;
            mp.largestBSTsize = lp.largestBSTsize+rp.largestBSTsize + 1;
        }else if(lp.largestBSTsize>rp.largestBSTsize){
            mp.largestBSTsize = lp.largestBSTsize;
            mp.largestBSTroot = lp.largestBSTroot;
        }else{
            mp.largestBSTsize = rp.largestBSTsize;
            mp.largestBSTroot = rp.largestBSTroot;
        }
        return mp;
    }

}
