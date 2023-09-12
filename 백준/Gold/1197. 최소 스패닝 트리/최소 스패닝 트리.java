import java.util.*;
import java.io.*;

// BJ #1197 - 최소 스패닝 트리
// Strategy: MST by Prim algorithm

public class Main {
	static int V,E;
	static List<List<Edge>> graph;
	
	public static class Edge implements Comparable<Edge>{
		int w;
		int cost;
		
		public Edge(int w, int cost) {
			this.w = w;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	
	public static int Prim(int n) {
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		
		pq.add(new Edge(n,0));
		
		int res = 0;
		while(!pq.isEmpty()) {
			Edge tmp = pq.poll();
			int v = tmp.w;
			int cost = tmp.cost;
			
			if(visited[v]) continue;
			
			visited[v] = true;
			res += cost;
			
			for(Edge e : graph.get(v)) {
				if(!visited[e.w]) {
					pq.add(e);
				}
			}
		}
		
		return res;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for(int i=0; i<=V; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
		
			graph.get(v1).add(new Edge(v2,c));
			graph.get(v2).add(new Edge(v1,c));
		}
		
		System.out.println(Prim(1));
	}
}
