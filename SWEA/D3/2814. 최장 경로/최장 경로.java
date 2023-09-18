import java.util.*;
import java.io.*;

// SWEA #2814 - 최장 경로
// Strategy: 

public class Solution {
	static int N,M,res;
	static List<List<Integer>> graph;
	static boolean[] visited;
	
	public static void dfs(int len, int n) {
		visited[n] = true;
		if(len > res) res = len;
		
		for(int v : graph.get(n)) {
			if(!visited[v]) {
				dfs(len+1, v);
				visited[v] = false;
			}
		}
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int t=1; t<=T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	
        	graph = new ArrayList<>();
        	for(int i=0; i<=N; i++) {
        		graph.add(new ArrayList<>());
        	}
        	
        	for(int i=0; i<M; i++) {
        		st = new StringTokenizer(br.readLine());
        		int x = Integer.parseInt(st.nextToken());
        		int y = Integer.parseInt(st.nextToken());
        		
        		graph.get(x).add(y);
        		graph.get(y).add(x);
        	}
        	
        	res = 1;
        	
        	for(int i=1; i<N; i++) {
        		visited = new boolean[N+1];
        		dfs(1,i);
        	}
        	
        	sb.append("#"+t).append(" ").append(res).append("\n");
        }
        
        System.out.println(sb);
    }
}