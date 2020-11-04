/*
Code : Get Path - BFS
Send Feedback
Given an undirected graph G(V, E) and two vertices v1 and v2(as integers), find and print the path from v1 to v2 (if exists). Print nothing if there is no path between v1 and v2.
Find the path using BFS and print the shortest path available.
V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
E is the number of edges present in graph G.
Print the path in reverse order. That is, print v2 first, then intermediate vertices and v1 at last.
Note : Save the input graph in Adjacency Matrix.
Input Format :
Line 1: Two Integers V and E (separated by space)
Next E lines : Two integers a and b, denoting that there exists an edge between vertex a and vertex b (separated by space)
Line (E+2) : Two integers v1 and v2 (separated by space)
Output Format :
Path from v1 to v2 in reverse order (separated by space)
Constraints :
2 <= V <= 1000
1 <= E <= 1000
0 <= v1, v2 <= V-1
Sample Input 1 :
4 4
0 1
0 3
1 2
2 3
1 3
Sample Output 1 :
3 0 1
Sample Input 2 :
6 3
5 3
0 1
3 4
0 3
Sample Output 2 :
*/
package getpathbfs;
import java.util.*;
public class GetPathBFS {
    public static ArrayList<Integer> getPathBFSHelper(int[][] edges, int sv, int ev, boolean[] visited){
        int n = edges.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        
        if(edges[sv][ev] == 1 && sv == ev){
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(sv);
            return ans;
        }
        queue.add(sv);
        visited[sv] = true;
        
        while(!queue.isEmpty()){
            int front = queue.remove();
            for(int i = 0; i < n; i++){
                if(edges[front][i] == 1 && !visited[i]){
                    map.put(i, front);
                    queue.add(i);
                    visited[i] = true;
                    
                    if(i == ev){
                        ArrayList<Integer> ans = new ArrayList<>();
                        ans.add(ev);
                        int value = map.get(ev);
                        
                        while(value != sv){
                            ans.add(value);
                            value = map.get(value);
                        }
                        ans.add(value);
                        return ans;
                    }
                }
            }
        }
        return null;
    }
    public static ArrayList<Integer> getPathBFS(int[][] edges, int sv, int ev){
        boolean[] visited = new boolean[edges.length];
        return getPathBFSHelper(edges, sv, ev, visited);
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
        
        
        int sv = s.nextInt();
        int ev = s.nextInt();
        
        s.close();
        
        ArrayList<Integer> ans = getPathBFS(edges, sv, ev);
        if(ans != null){
            for(int elem: ans ){
                System.out.print(elem + " ");
            }
        }
    }
    
}
