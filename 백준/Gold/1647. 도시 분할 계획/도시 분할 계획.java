import java.util.*;
import java.io.*;

// BJ #1647 - 도시 분할 계획
// Strategy: MST(Prim)

public class Main {
	static int V,E;
	static List<List<Edge>> graph;
	
	static class Edge implements Comparable<Edge>{
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
	
	static int Prim(int n) {
		boolean[] visited = new boolean[V+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Edge[] selected = new Edge[V];
		int idx = 0;
		
		pq.add(new Edge(1,0));
		
		int res = 0;
		while(!pq.isEmpty()) {
			Edge tmp = pq.poll();
			int v = tmp.w;
			int cost = tmp.cost;
			
			if(visited[v]) continue;
			
			visited[v] = true;
			res += cost;
			selected[idx++] = tmp;
			
			for(Edge e : graph.get(v)) {
				if(!visited[e.w]) {
					pq.add(e);
				}
			}
		}
		
		// 스패닝 트리를 구하고 cost가 가장 높은 길 1개를 더 없앤다.
		int max = 0;
		for(Edge e: selected) {
			if(e.cost > max) {
				max = e.cost;
			}
		}

		return res-max;
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		// 그래프 초기화
		graph = new ArrayList<>();
		for(int i=0; i<=V; i++) {
			graph.add(new ArrayList<>());
		}
		
		// 그래프 정보 입력
		for(int i=0; i<E; i++){
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph.get(v).add(new Edge(w,cost));
			graph.get(w).add(new Edge(v,cost));
		}
		
		System.out.println(Prim(1));
	}
}
