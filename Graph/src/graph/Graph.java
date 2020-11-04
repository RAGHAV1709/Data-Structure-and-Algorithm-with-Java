package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {
    public static void printHelper(int edges[][], int sv, boolean visited[]){
        System.out.println(sv);
        visited[sv] = true;
        //System.out.println("Edge length: "+edges.length);
        int n = edges.length;
        for(int i = 0; i < n; i++){
            if(edges[sv][i] == 1 && !visited[i]){
                printHelper(edges, i, visited);
            }
        }
    }
    public static void print(int edges[][]){
        boolean visited[] = new boolean[edges.length];
        for(int i = 0; i < edges.length; i++){
            if(!visited[i]){
                printHelper(edges, i, visited);
            }
        }
        
    }
    public static void printBFSHelper(int edges[][], int sv, boolean visited[]){
        Queue<Integer> queue = new LinkedList<>();
        visited[sv] = true;
        queue.add(sv);
        while(!queue.isEmpty()){
            int front = queue.remove();
            System.out.print(front + " ");
            for(int i = 0; i < edges.length; i++){
                if(edges[front][i] == 1 && !visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        
    }
    public static void printBFS(int edges[][]){
        boolean visited[] = new boolean[edges.length];
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                printBFSHelper(edges, i, visited);
            }
        }
    }
    public static boolean BFS(int edges[][], int sv, int ev, boolean visited[]){
        if(edges[sv][ev] == 1){
            return true;
        }
        Queue<Integer> queue = new LinkedList<>();
        visited[sv] = true;
        queue.add(sv);
        
        while(!queue.isEmpty()){
            int front = queue.remove();
            
            for(int i = 0; i < edges.length; i++){
                if(edges[front][i] == 1 && !visited[i]){
                    if(i == ev){
                        return true;
                    }
                    else{
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }
        }
        return false;
    }
    private static boolean hasPath(int[][] edges, int sv, int ev){
        boolean visited[] = new boolean[edges.length];
        return BFS(edges, sv, ev, visited);
    }
    public static void DFS(int[][] edges, int sv,boolean[] visited ){
        visited[sv] = true;
        for(int i = 0; i < edges.length; i++){
            if(edges[sv][i] == 1 && !visited[i]){
                DFS(edges, i,visited);
                visited[i] = true;
            }
        }
    }
    public static boolean isConnected(int[][] edges){
        boolean[] visited = new boolean[edges.length];
        
        DFS(edges, 0, visited);
        
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int n;
        int e;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        e = s.nextInt();
        int edges[][] = new int[n][n];
        for(int i = 0; i < e; i++){
            int fv = s.nextInt();
            int sv = s.nextInt();
            edges[fv][sv] = 1;
            edges[sv][fv] = 1;
        }
        //print(edges);
        //printBFS(edges);
        System.out.println(isConnected(edges));
        int sv = s.nextInt();
        int ev = s.nextInt();

        
        System.out.println(hasPath(edges, sv, ev));
    }
    
}
