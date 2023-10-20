import java.util.*;
import java.io.*;

class Solution {  
    static List<List<Integer>> graph;
    
    public int BFS(int start, int n){
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new ArrayDeque<>();
        int res = 0;
        
        q.add(start);
        visited[start] = true;
        
        while(!q.isEmpty()){
            int size = q.size();
            res = size;
            
            while(size-->0){
                int tmp = q.poll();
                for(int v : graph.get(tmp)){
                    if(!visited[v]){
                        q.add(v);
                        visited[v] = true;
                    }
                }
            }
        }
        
        return res;
    }
    
    public int solution(int n, int[][] edge) {
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<edge.length; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        return BFS(1,n);
    }
}