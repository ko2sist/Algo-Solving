import java.util.*;

class Solution {
    int min;
    int[][] graph;
    boolean[] visited;
    
    public int BFS(int n, int n2){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(n);
        visited[n] =true;
        int res = 1;
        
        while(!q.isEmpty()){
            int tmp = q.poll();
            
            for(int i=1; i<=n2; i++){
                if(graph[tmp][i]==1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                    res++;
                }
            }
        }
        
        return res;
    }
    
    public void check(int n){
        visited = new boolean[n+1];
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                list.add(BFS(i,n));
                cnt++;
            }
            
            if(list.size()==2) break;
        }
        
        min = Math.min(min, Math.abs(list.get(0)-list.get(1)));
    }
    public int solution(int n, int[][] wires) {
        
        int len = wires.length;
        
        // 그래프 정보 입력
        graph = new int[n+1][n+1];        
        for(int i=0; i<len; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }
        
        //
        min = (int)1e9;
        for(int i=0; i<len; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph[v1][v2] = 0;
            graph[v2][v1] = 0;
            
            check(n);
            
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }
        
        return min;
    }
}