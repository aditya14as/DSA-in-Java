package com.aditya.Graph;

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
        boolean[] visited = new boolean[vces];

//        System.out.println(hasPath(graph,0,6,visited));
        printAllPath(graph,0,6,visited,"0",2,0,40); //criteria is for finding ceil and floor
        System.out.println("Max path: "+maxPath+"@"+maxPathW);
        System.out.println("Min path: "+ minPath+"@"+minPathW);
        System.out.println("Ceil path: "+ceilPath+"@"+ceilPathW);
        System.out.println("Floor path: "+floorPath+"@"+floorPathW);
        System.out.println("Kth largest path: "+pq.peek().path+"@"+pq.peek().wsf);
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
        for(Edge edge : graph[src]){
            if(!visited[edge.nbr]){
                printAllPath(graph,edge.nbr,dest,visited,path+edge.nbr,k,wsf+edge.wt,criteria);
            }
        }
        visited[src] = false;
    }
}
