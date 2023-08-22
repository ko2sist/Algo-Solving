import java.util.*;
import java.io.*;

// BJ #1238 - 파티
// Strategy: 다익스트라
public class Main {
	static int[][] graph;
	static int N;
	static int INF = (int)1e9;
	
	public static class Node implements Comparable<Node>{
		int n;
		int w;
		int uid;
		
		public Node(int n, int w, int uid) {
			this.n = n;
			this.w = w;
			this.uid = uid;
		}
		
		public int compareTo(Node o) {
			if(this.w != o.w) {
				return this.w - o.w;
			}else {
				return this.uid - o.uid;
			}
		}
	}
	
	public static int dijkstra(int start, int end) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		
		int uid = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(start, 0, uid++));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			
			for(int i=1; i<=N; i++) {
				if(graph[tmp.n][i] != 0 && dist[i] > dist[tmp.n]+graph[tmp.n][i]) {
					dist[i] = dist[tmp.n]+graph[tmp.n][i];
					pq.add(new Node(i, dist[tmp.n]+graph[tmp.n][i], uid++));
				}
			}
		}
		
		return dist[end];
	}
	
	public static int[] dijkstra(int start) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		
		int uid = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(start, 0, uid++));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			
			for(int i=1; i<=N; i++) {
				if(graph[tmp.n][i] != 0 && dist[i] > dist[tmp.n]+graph[tmp.n][i]) {
					dist[i] = dist[tmp.n]+graph[tmp.n][i];
					pq.add(new Node(i, dist[tmp.n]+graph[tmp.n][i], uid++));
				}
			}
		}
		
		return dist;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[u][v] = w;
		}
		
		int max = 0;
		int[] dist_fromX = dijkstra(X);
		for(int i=1; i<=N; i++) {
			int tmp = dijkstra(i,X) + dist_fromX[i];
			if(tmp > max) {
				max = tmp;
			}
		}
		
		System.out.println(max);
		
		
	}
}
