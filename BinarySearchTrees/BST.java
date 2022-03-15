package com.aditya.BinarySearchTrees;

import com.aditya.BinaryTrees.BinaryTree;

import java.util.Stack;

public class BST {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
        public Node(int data,Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args){
        int[] arr = {12,25,37,50,62,75,87};
        Node root = construct(arr,0,arr.length-1);
//        display(root);
//        System.out.println(max(root).data+" "+min(root).data);
//        Node node = addNode(root,61);
//        display(node);
        display(removeNode(root,75));
    }
    public static Node construct(int[] arr, int start ,int end){
        if(start>end){
            return null;
        }
        int mid = start + (end - start)/2;
        Node ln = construct(arr,start,mid-1);
        Node rn = construct(arr,mid+1,end);
        Node root = new Node(arr[mid],ln,rn);
        return root;
    }
    public static boolean find(Node root, int val){
        if(root == null){
            return false;
        }
        if(root.data > val){
           return find(root.left,val);
        }
        else if(root.data<val){
            return find(root.right,val);
        }
        else return true;
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
    public static int sum(Node root){
        if(root==null){
            return 0;
        }
        return sum(root.left)+sum(root.right)+root.data;
    }
    public static Node max(Node root){
        if(root.right != null){
            return max(root.right);
        }
        else{
            return root;
        }
    }
    public static Node min(Node root){
        if(root.left != null){
            return min(root.left);
        }
        else{
            return root;
        }
    }
    public static Node addNode(Node root,int val){
        if(root==null){
            Node node = new Node(val);
            return node;
        }
        if(val>root.data){
            root.right = addNode(root.right,val);
        }
        else if (val<root.data){
           root.left =  addNode(root.left,val);
        }
        return root;
    }
    public static Node removeNode(Node root,int val){
        if(root==null){
            return null;
        }
        if(root.data>val){
            root.left = removeNode(root.left,val);
        }else if(root.data<val){
            root.right = removeNode(root.right,val);
        }else{
            if(root.left!= null && root.right!=null){ //two child
                Node max = max(root.left);
                root.data = max.data;
                root.left = removeNode(root.left,max.data);
                return root;
            }
            else if(root.right!=null){ //One child
                return root.right;
            }else if(root.left!=null){
                return root.left;
            }else{
                return null;
            }
        }
        return root;
    }
    public static int sum = 0;
    public static void replaceSumOfLarger(Node root){
        if(root==null){
            return;
        }
        replaceSumOfLarger(root.right);
        int temp = root.data;
        root.data = sum;
        sum = temp+sum;
        replaceSumOfLarger(root.left);
    }
    public static int findLCA(Node root,int a ,int b){
        if(root.data>a && root.data>b){
            return findLCA(root.left,a,b);
        }
        else if(root.data<a && root.data<b){
           return findLCA(root.right,a,b);
        }
        else{
            return root.data;
        }
    }
    public static void printInRange(Node root, int low, int high){
        if(root == null){
            return;
        }
        if(root.data < low && root.data<high){
            printInRange(root.right,low, high);
        }else if(root.data> low && root.data > high){
            printInRange(root.left,low ,high);
        }else{
            printInRange(root.left,low, high);
            System.out.println(root.data+" ");
            printInRange(root.right,low,high);
        }
    }
    //Time complexity is nlogn(nh(h==height)) and space complexity is equal to height
    public static void targetSumPair(Node root, Node node, int target){
        if(node == null){
            return;
        }
        targetSumPair(root,node.left,target);
        int comp = target - node.data;
        if(comp>node.data){
            if(find(root,comp)){
                System.out.println(node.data+" "+comp);
            }
        }
        targetSumPair(root,node.right,target);

    }
    // Another approach is travel and fill all the values of BST in inorder it will fill up in sorted order
    // then take two pointers one is from start and other is from end if both elements add upto target print and change start and end pointers
    // Time complexity for this aproach will be n which is better than 1st approach but space complexity will be also n which is greater than earlier

    //  This approach will take space complexity of h and time complexity of n
    public static class ITPair{
        Node node;
        int state=0;
        public ITPair(Node node,int state){
            this.node = node;
            this.state = state;
        }
    }
    public static void targetSumPair2(Node root, int target){
        Stack<ITPair> ls = new Stack<>();
        Stack<ITPair> rs = new Stack<>();
        ls.push(new ITPair(root,0));
        rs.push(new ITPair(root,0));
        Node left = getNextFromNormalInorder(ls);
        Node right = getNextFromReverseInorder(rs);
        while(left.data < right.data){
            if(left.data+right.data<target){
                left = getNextFromNormalInorder(ls);
            }else if(left.data+right.data>target){
                right = getNextFromReverseInorder(rs);
            }else{
                System.out.println(left.data + " " + right.data);
                left = getNextFromNormalInorder(ls);
                right = getNextFromReverseInorder(rs);
            }
        }
    }
    public static Node getNextFromNormalInorder(Stack<ITPair> st){
        while(!st.empty()){
            ITPair top = st.peek();
            if(top.state == 0){
                if(top.node.left != null){
                    st.push(new ITPair(top.node.left,0));
                }
                top.state++;
            }else if(top.state == 1){
                if(top.node.right != null){
                    st.push(new ITPair(top.node.right,0));
                }
                top.state++;
                return top.node;

            }else{
                st.pop();
            }
        }
        return null;
    }
    public static Node getNextFromReverseInorder(Stack<ITPair> st){
        while(!st.empty()){
            ITPair top = st.peek();
            if(top.state == 0){
                if(top.node.right != null){
                    st.push(new ITPair(top.node.right,0));
                }
                top.state++;
            }else if(top.state == 1){
                if(top.node.left != null){
                    st.push(new ITPair(top.node.left,0));
                }
                top.state++;
                return top.node;
            }else{
                st.pop();
            }
        }
        return null;
    }
}
