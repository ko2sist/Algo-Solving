import java.util.*;
import java.io.*;

// SWEA #1267 - 작업순서
// Strategy: 위상정렬

public class Solution {
	static int V, E;
	static List<List<Integer>> graph;
	static StringBuilder sb;
	static boolean[] visited, finished;
	static Stack<Integer> stack;
	static boolean cycle;
	
	public static void dfs(int n) {
		visited[n] = true;
		
		for(int v: graph.get(n)) {
			if(!visited[v]) {
				dfs(v);
			}else if(!finished[v]) {
				cycle = true;
				return;
			}
		}
		finished[n] = true;
		stack.add(n);
	}
	
	public static void TS() {
		visited = new boolean[V+1];
		finished = new boolean[V+1];
		stack = new Stack<>();
		
		for(int i=1; i<=V; i++) {
			if(cycle) return;
			
			if(!visited[i]) {
				dfs(i);
			}
		}
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        // T: 테스트 케이스 개수
        int T = 10;
        for(int t=1; t<=T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	V = Integer.parseInt(st.nextToken());
        	E = Integer.parseInt(st.nextToken());
        	
        	graph = new ArrayList<>();
        	for(int i=0; i<=V; i++) {
        		graph.add(new ArrayList<>());
        	}
        	
        	st = new StringTokenizer(br.readLine());
        	for(int i=0; i<E; i++) {
        		int u = Integer.parseInt(st.nextToken());
        		int v = Integer.parseInt(st.nextToken());
        		
        		graph.get(u).add(v);
        	}

        	
        	// 현재 테스트 케이스 결과 저장
        	sb.append("#"+t).append(" ");
        	TS();
        	while(!stack.isEmpty()) {
        		sb.append(stack.pop()).append(" ");
        	}
        	sb.append("\n");
        }
        
        // 최종 결과 출력
        System.out.println(sb);
    }
}