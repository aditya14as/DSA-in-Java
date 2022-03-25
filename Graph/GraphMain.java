package com.aditya.Graph;

import java.lang.reflect.Array;
import java.util.*;

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


//        for (int i = 0; i < vces; i++) {
//            if(visited[i]==false){
//                if(isCyclicUsingBFS(graph,i,"i",visited)){
//                    System.out.println("Graph is Cyclic");
//                    return;
//                }
//            }
//        }
//        System.out.println("Graph is not Cyclic");


//        int[] visit = new int[vces];
//        Arrays.fill(visit,-1);
//        for (int i = 0; i < vces; i++) {
//            if(visit[i] == -1){
//                if(isGraphBipartite(graph,i,i+"",visit)==false){
//                    System.out.println(false);
//                    return;
//                }
//            }
//        }
//        System.out.println(true);


//        dikshtraAlgorithm(graph,0,6,visited,0+"");

//        primsAlgorithm(graph,0,visited);

//        iterativeDFS(graph,0,visited);

//        Stack<Integer> st = new Stack<>();
//        for (int i = 0; i < vces; i++) {
//            if(visited[i]==false){
//                topologicalSort(graph,i,visited,st);
//            }
//        }
//        while(st.empty()==false){
//            System.out.println(st.pop());
//        }
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

    public static class QPair{
        int value;
        String psf;
        QPair(int value,String psf){
            this.value = value;
            this.psf = psf;
        }
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

    public static class BipartitePair{
        int val;
        String psf;
        int level;
        BipartitePair(int val,String psf,int level){
            this.val = val;
            this.psf = psf;
            this.level = level;
        }
    }
    public static boolean isGraphBipartite(ArrayList<Edge>[] graph,int src,String psf,int[] visited){
        // Is graph bipartite? Which means it's possible to divide vertices into two mutually exclusive & exhaustive subsets
        // such that all edges are across sets. All Acyclic graph, and cycle with even edges are bipartite
        // But cycle with odd edges are not bipartite because when we traverse level order to add into two mutually subsets
        // it will try to add into both the subsets because of traversing 2 times at different level
        ArrayDeque<BipartitePair> q = new ArrayDeque<>();
        q.add(new BipartitePair(src,src+"",0));
        while(!q.isEmpty()){
            // Operation of Remove,Marked, Worked and Add all neighbour
            BipartitePair pair = q.remove(); // Remove
            if(visited[pair.val] == -1){
                visited[pair.val]=pair.level; // Marked visited
            }else{
                if(visited[pair.val] != pair.level){
                    return false;
                }
            }
            for (int i = 0; i < graph[pair.val].size(); i++) {
                if(visited[graph[pair.val].get(i).nbr] == -1){ // Add all children
                    q.add(new BipartitePair(graph[pair.val].get(i).nbr, pair.psf+graph[pair.val].get(i).nbr,pair.level+1));
                }
            }
        }
        return true;

        // Spread infection is the application of this.
        // Q. If source is infected with virus at t=1 then their neighbour is infected with t=t+1 then you have to find out that
        // how much total time to infect all the person?
        // Solution:- Time at which a particular person is infected is equal to the minimum no of level of BFS
        // Then after traversing last person the level of that person will be total time
    }

    public static class DPair implements Comparable<DPair>{
        int val;
        String psf;
        int wt;
        DPair(int val,String psf,int wt){
            this.val = val;
            this.psf = psf;
            this.wt = wt;
        }
        public int compareTo(DPair o){
            return this.wt-o.wt;
        }
    }
    public static void dikshtraAlgorithm(ArrayList<Edge>[] graph,int src,int dest,boolean[] visited,String psf){
        //This algorithm is used where we have to find path in terms of weight(can be configured as max or min)
        //Here, We created priority queue which compared pair and returns the pair with minimum weight
        PriorityQueue<DPair> pq = new PriorityQueue<>();
        pq.add(new DPair(src,src+"",0));
        while(pq.size()>0){
            DPair pair = pq.remove();
            System.out.println(pair.psf+"@"+pair.wt);
            if(pair.val==dest){
                break;
            }
            if(visited[pair.val]==false){
                visited[pair.val]=true;
            }
            for (int i = 0; i < graph[pair.val].size(); i++) {
                if(visited[graph[pair.val].get(i).nbr]==false){
                    pq.add(new DPair(graph[pair.val].get(i).nbr,pair.psf+graph[pair.val].get(i).nbr,pair.wt+graph[pair.val].get(i).wt));
                }
            }
        }
    }

    public static class PPair implements Comparable<PPair>{
        int val;
        int adjVertices;
        int wt;
        PPair(int val,int adjVertices,int wt){
            this.val = val;
            this.adjVertices = adjVertices;
            this.wt = wt;
        }
        public int compareTo(PPair o){
            return this.wt-o.wt;
        }
    }
    public static void primsAlgorithm(ArrayList<Edge>[] graph,int src,boolean[] visited){
        //This algorithm is used for creating minimum spanning tree,(spanning means all vertex should be included)
        // A spanning tree is a sub-graph of an undirected connected graph,
        // which includes all the vertices of the graph with a minimum possible number of edges.
        // If a vertex is missed, then it is not a spanning tree.
        // It should be acyclic
        // Application:- To find minimum length of wire to connect a lan,paths in the map etc
        PriorityQueue<PPair> pq = new PriorityQueue<>();
        pq.add(new PPair(src,-1,0));
        while(pq.isEmpty()==false){
            PPair pair = pq.remove();
            if(visited[pair.val]==true){
                continue;
            }
            visited[pair.val]=true;
            if(pair.adjVertices != -1){  // It will not print first pair as it's the source
                System.out.println(pair.val+"@"+pair.wt);
            }
            for (int i = 0; i < graph[pair.val].size(); i++) {
                if(visited[graph[pair.val].get(i).nbr]==false){
                    pq.add(new PPair(graph[pair.val].get(i).nbr,pair.val,graph[pair.val].get(i).wt));
                }
            }
        }
    }

    public static void iterativeDFS(ArrayList<Edge>[] graph,int src,boolean[] visited){
        //Iterative DFS is very helpful because in recursion creative more than 10k calls in java gives stackoverflow exception
        //Recursive calls creates in call stack memory and call stack memory is very small
        //In iterative DFS we just put a reference in call stack memory of stack class object and stack class object created in heap memory
        // We know that there is no limitation of heap memory

        //In interative BFS we create pair and puts it into queue, but in DFS when we replace queue with Stack then its call
        // will be made like reverse eular path(i.e DFS traversal)
        Stack<QPair> st = new Stack<>();
        st.push(new QPair(src,src+""));
        while(st.isEmpty()==false){
            QPair pair = st.pop(); //Remove
            if (visited[pair.value]==true){
                continue;
            }
            visited[pair.value]=true; //Marked
            System.out.println(pair.psf); //Worked
            for (int i = 0; i < graph[pair.value].size(); i++) {
                if(visited[graph[pair.value].get(i).nbr]==false){
                    st.add(new QPair(graph[pair.value].get(i).nbr,pair.psf+graph[pair.value].get(i).nbr)); //Add
                }
            }
        }
    }

    public static void topologicalSort(ArrayList<Edge>[] graph,int src,boolean[] visited,Stack<Integer> st){
        //Topological Sort:- A permutation of vetices for a directed acyclic graph(Graph must be DAG) is called topoplogical sort if for all
        //directed edges uv, u appears before v in the graph
        // Topological Sorting has been proved to be very helpful in solving the Course Schedule problem.
        //Other applications like manufacturing workflows, data serialization etc. where one process is dependent on the other
        visited[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            if (visited[graph[src].get(i).nbr]==false) {
                topologicalSort(graph,graph[src].get(i).nbr,visited,st);
            }
        }
        st.push(src);
    }
}
