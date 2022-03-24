package com.aditya.Graph;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class GraphMain {
    public static class Edge{
        int src;
        int nbr;
        int wt;
        Edge(int src,int nbr,int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public static class Pair implements Comparable<Pair>{
        int wsf;
        String path;
        Pair(int wsf, String path){
            this.wsf = wsf;
            this.path = path;
        }
        public int compareTo(Pair o){
            return this.wsf - o.wsf;
        }
    }
    public static class QPair{
        int value;
        String psf;
        QPair(int value,String psf){
            this.value = value;
            this.psf = psf;
        }
    }
    public static void main(String[] args){
        int vces = 7; // 0,1,2,3,4,5,6
        ArrayList<Edge>[] graph = new ArrayList[vces];  // int[] arr = new int[7];
        for (int i = 0; i < vces; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,3,40));
        graph[0].add(new Edge(0,1,10));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,2,10));

        graph[2].add(new Edge(2,3,10));
        graph[2].add(new Edge(2,1,10));
        graph[2].add(new Edge(2,6,10));


        graph[3].add(new Edge(3,0,40));
        graph[3].add(new Edge(3,2,10));
        graph[3].add(new Edge(3,4,2));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,3));
        graph[4].add(new Edge(4,6,3));

        graph[5].add(new Edge(5,4,3));
        graph[5].add(new Edge(5,6,3));

        graph[6].add(new Edge(6,5,3));
        graph[6].add(new Edge(6,4,8));
        graph[6].add(new Edge(6,2,10));

        boolean[] visited = new boolean[vces];

//        System.out.println(hasPath(graph,0,6,visited));
//        printAllPath(graph,0,6,visited,"0",2,0,40); //criteria is for finding ceil and floor
//        System.out.println("Max path: "+maxPath+"@"+maxPathW);
//        System.out.println("Min path: "+ minPath+"@"+minPathW);
//        System.out.println("Ceil path: "+ceilPath+"@"+ceilPathW);
//        System.out.println("Floor path: "+floorPath+"@"+floorPathW);
//        System.out.println("Kth largest path: "+pq.peek().path+"@"+pq.peek().wsf);
//        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//        for (int i = 0; i < vces; i++) {
//            if(visited[i]==false){
//                ArrayList<Integer> comp = new ArrayList<>();
//                getConnectedComponent(graph,i,visited,comp);
//                list.add(comp);
//            }
//        }
//        System.out.println(list);
//        hamiltonianPathAndCycle(graph,0,visited,"0",0);
//        bfsTraversal(graph,0,visited);
        for (int i = 0; i < vces; i++) {
            if(visited[i]==false){
                if(isCyclicUsingBFS(graph,i,"i",visited)){
                    System.out.println("Graph is Cyclic");
                    return;
                }
            }
        }
        System.out.println("Graph is not Cyclic");
    }
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest,boolean[] visited){
        if(src==dest){
            return true;
        }
        visited[src] =true;
        for(Edge edge : graph[src]){
            if(!visited[edge.nbr]){
                boolean hasNbrPath = hasPath(graph,edge.nbr,dest,visited);
                if(hasNbrPath){
                    return true;
                }
            }
        }
        return false;
    }

    public static String maxPath;
    public static String minPath;
    public static String ceilPath;
    public static String floorPath;
    public static Integer maxPathW = Integer.MIN_VALUE;
    public static Integer minPathW = Integer.MAX_VALUE;
    public static Integer ceilPathW = Integer.MAX_VALUE;
    public static Integer floorPathW = Integer.MIN_VALUE;
    public static PriorityQueue<Pair> pq = new PriorityQueue<>();

    public static void printAllPath(ArrayList<Edge>[] graph, int src, int dest,boolean[] visited,String path,int k,int wsf,int criteria){
        if(src==dest){
            if(wsf < minPathW){
                minPath = path;
                minPathW = wsf;
            }
            if(wsf>maxPathW){
                maxPath = path;
                maxPathW = wsf;
            }
            if(wsf>criteria && wsf<ceilPathW){
                ceilPathW = wsf;
                ceilPath = path;
            }
            if(wsf<criteria && wsf>floorPathW){
                floorPath = path;
                floorPathW = wsf;
            }
            if(pq.size()<k){
                pq.add(new Pair(wsf,path));
            }else{
                if(pq.peek().wsf<wsf){
                    pq.remove();
                    pq.add(new Pair(wsf,path));
                }
            }
            return;
        }
        visited[src] =true;
        for(int i = 0; i<graph[src].size(); i++){
            if(!visited[graph[src].get(i).nbr]){
                printAllPath(graph,graph[src].get(i).nbr,dest,visited,path+graph[src].get(i).nbr,k,wsf+graph[src].get(i).wt,criteria);
            }
        }
        visited[src] = false;
    }

    public static void getConnectedComponent(ArrayList<Edge>[] graph,int src,boolean[] visited,ArrayList<Integer> comp){
        visited[src] = true;
        comp.add(src);
        for (int i = 0; i < graph[src].size(); i++) {
            if(visited[graph[src].get(i).nbr]==false){
                getConnectedComponent(graph,graph[src].get(i).nbr,visited,comp);
            }
        }

        // Q. Similary we can solve this for graph connected or not?
        // if this funtion yeilds more than one arraylist then we can conclude that
        // graph has two parts which means graph is not connected

        // Q. Similary we can solve for no of perfect pair of friends
        // Perfect pair can be created by selecting one from 1st ArrayLists of list and 2nd from another ArrayList
        // You can't selected two friends from same inner arraylist. solution below
//        int count = 0;
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = i+1; j < list.size(); j++) {
//                count =count + list.get(i).size() * list.get(j).size();
//            }
//        }
    }

    public static void hamiltonianPathAndCycle(ArrayList<Edge>[] graph, int src, boolean[] visited,String psf,int originalSource){
        if(psf.length()== graph.length){
            for (int i = 0; i < graph[src].size(); i++) {
                if(graph[src].get(i).nbr==originalSource){
                    System.out.println(psf+"@Circular");
                    return;
                }
            }
            System.out.println(psf+"@NotCircular");
            return;
        }
        visited[src] = true;
        for (int k = 0; k < graph[src].size(); k++) {
            if(visited[graph[src].get(k).nbr]==false){
                hamiltonianPathAndCycle(graph,graph[src].get(k).nbr,visited,psf+graph[src].get(k).nbr,originalSource);
            }
        }
        visited[src]=false;

    }
    public static void bfsTraversal(ArrayList<Edge>[] graph,int src,boolean[] visited){

        ArrayDeque<QPair> q = new ArrayDeque<>();
        q.add(new QPair(src,src+""));
        while(q.size()!=0){
            // For any BreadthFirst traversal or level order traversal remember the steps
            // First remove from queue, 2nd Marked, 3rd worked what you have to do(here we have to print) and 4th add all the neighbour
            QPair pair = q.remove();
            if (visited[pair.value]==false){
                visited[pair.value]=true;
                System.out.println(pair.psf);
                for (int i = 0; i < graph[pair.value].size(); i++) {
                    q.add(new QPair(graph[pair.value].get(i).nbr,pair.psf+graph[pair.value].get(i).nbr));
                }
            }
        }
    }
    public static boolean isCyclicUsingBFS(ArrayList<Edge>[] graph,int src,String psf, boolean[] visited){
        ArrayDeque<QPair> q = new ArrayDeque<>();
        q.add(new QPair(src,src+""));
        while(q.size()>0){
            QPair pair = q.remove();
            if(visited[pair.value]==true){
                return true;
            }
                visited[pair.value]=true;
                for (int i = 0; i < graph[pair.value].size(); i++) {
                   if(visited[graph[pair.value].get(i).nbr]==false){
                       q.add(new QPair(graph[pair.value].get(i).nbr,pair.psf+graph[pair.value].get(i).nbr));
                   }
                }

        }
        return false;
    }
}
